"""
Run ClassEval method-level unit tests for the rebuttal.

Pipeline per (language, model, iteration, method_id):
  1. Parse the method's task_id + method_name out of the id ("ClassEval_X::method").
  2. Take the ground-truth class (`solution_code` from ClassEval_data.json) and
     replace the target method definition with the generated method using an AST
     splice. This isolates the generated method while all other methods remain
     correct (same as the 'compositional' setting in the ClassEval paper).
  3. Append the class's test module (`test`) and run ONLY the test class that
     covers this specific method (from `test_classes` / per-method `test_class`).
  4. Record errors / failures / testsRun → pass = 1 iff errors+failures == 0 and
     testsRun > 0.

Inputs:
  data/rebuttal/{lang}/{lang}_python_generated_code-{i}.csv     (Claude, 10 iters)
  data/classeval_manual_analysis/<...>/python_{lang}_{model}.csv (GPT + DeepSeek, 1 iter)
  /tmp/ClassEval/data/ClassEval_data.json                       (benchmark data)

Output:
  data/rebuttal/classeval_results/classeval_test_results.csv

Run with the classeval venv:
  /tmp/nb_venv/bin/python scripts/classeval_run_tests.py [--workers N] [--combo lang:model]
"""

import argparse
import ast
import csv
import json
import multiprocessing as mp
import os
import subprocess
import sys
import tempfile
from pathlib import Path

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
REBUTTAL = os.path.join(BASE, "data", "rebuttal")
MANUAL = os.path.join(BASE, "data", "classeval_manual_analysis")
OUT_DIR = os.path.join(REBUTTAL, "classeval_results")
os.makedirs(OUT_DIR, exist_ok=True)

CLASSEVAL_DATA = "/tmp/ClassEval/data/ClassEval_data.json"

MODELS = ["gpt", "deepseek", "claude"]
LANGUAGES = ["english", "chinese", "hindi", "spanish", "italian"]

MANUAL_MAP = {
    ("chinese", "gpt"): ("Chinese_labeled/python_chinese_gpt.csv", ","),
    ("chinese", "deepseek"): ("Chinese_labeled/python_chinese_deepseek.csv", ","),
    ("italian", "gpt"): ("italian-manual-analysis/python_italian_gpt.csv", ","),
    ("italian", "deepseek"): ("italian-manual-analysis/python_italian_deepseek.csv", ","),
    ("spanish", "gpt"): ("spanish-manual-analysis/python_spanish_gpt.csv", ";"),
    ("spanish", "deepseek"): ("spanish-manual-analysis/python_spanish_deepseek.csv", ","),
    ("hindi", "gpt"): ("hindi-manually-analyzed/python_hindi_gpt - python_hindi_gpt.csv", ","),
    ("hindi", "deepseek"): ("hindi-manually-analyzed/python_hindi_deepseek - python_hindi_deepseek.csv", ","),
    ("english", "gpt"): ("python_english_gpt.csv", ","),
    ("english", "deepseek"): ("python_english_deepseek.csv", ","),
    ("english", "claude"): ("python_english_claude.csv", ","),
}


def sources_for(lang, model):
    """Return [(iter_idx, csv_path, delimiter), ...] for a (lang, model)."""
    out = []
    if model == "claude":
        for i in range(10):
            p = os.path.join(REBUTTAL, lang, f"{lang}_python_generated_code-{i}.csv")
            if os.path.exists(p):
                out.append((i, p, ","))
        if out:
            return out
    key = (lang, model)
    if key in MANUAL_MAP:
        rel, delim = MANUAL_MAP[key]
        p = os.path.join(MANUAL, rel)
        if os.path.exists(p):
            return [(0, p, delim)]
    return out


def load_classeval():
    with open(CLASSEVAL_DATA) as f:
        data = json.load(f)
    by_id = {item["task_id"]: item for item in data}
    # Build per-method test_class lookup:  (task_id, method_name) -> test_class name
    method_tc = {}
    for item in data:
        for m in item.get("methods_info", []):
            method_tc[(item["task_id"], m["method_name"])] = m.get("test_class")
    return by_id, method_tc


def replace_method(class_source, method_name, new_method_code):
    """Return modified class_source with method_name replaced by new_method_code,
    or None if the substitution fails.

    new_method_code is expected to be a single method def (optionally with import
    statements at the top, which we strip). The top-level imports of class_source
    are preserved.
    """
    try:
        tree = ast.parse(class_source)
    except SyntaxError:
        return None
    try:
        new_tree = ast.parse(new_method_code)
    except SyntaxError:
        return None
    new_def = None
    # First pass: top-level function with matching name
    for n in new_tree.body:
        if isinstance(n, (ast.FunctionDef, ast.AsyncFunctionDef)) and n.name == method_name:
            new_def = n
            break
    # Second pass: method inside a top-level class definition
    if new_def is None:
        for n in new_tree.body:
            if isinstance(n, ast.ClassDef):
                for item in n.body:
                    if isinstance(item, (ast.FunctionDef, ast.AsyncFunctionDef)) and item.name == method_name:
                        new_def = item
                        break
                if new_def is not None:
                    break
    if new_def is None:
        # If generated code has no matching method, give up
        return None
    replaced = False
    for node in ast.walk(tree):
        if isinstance(node, ast.ClassDef):
            for i, item in enumerate(node.body):
                if isinstance(item, (ast.FunctionDef, ast.AsyncFunctionDef)) and item.name == method_name:
                    node.body[i] = new_def
                    replaced = True
                    break
            if replaced:
                break
    if not replaced:
        return None
    try:
        return ast.unparse(tree)
    except Exception:
        return None


def run_one_test(task, test_class_name, full_code, timeout=10):
    """Write full_code to a temp file and invoke `python -m unittest file.TestClass`.

    Returns dict(errors, failures, testsRun, passed, reason).
    """
    with tempfile.TemporaryDirectory() as tmpdir:
        mod_name = "candidate_" + task["task_id"].replace(":", "_")
        path = os.path.join(tmpdir, mod_name + ".py")
        with open(path, "w") as f:
            f.write(full_code)
        env = os.environ.copy()
        env["PYTHONPATH"] = tmpdir + os.pathsep + env.get("PYTHONPATH", "")
        try:
            proc = subprocess.run(
                [sys.executable, "-m", "unittest", "-v", f"{mod_name}.{test_class_name}"],
                cwd=tmpdir, env=env, capture_output=True, text=True, timeout=timeout,
            )
        except subprocess.TimeoutExpired:
            return {"errors": 0, "failures": 0, "testsRun": 0, "passed": False, "reason": "timeout"}
        except Exception as e:
            return {"errors": 0, "failures": 0, "testsRun": 0, "passed": False, "reason": f"runner_error:{e}"}

        # Parse unittest output (on stderr)
        out = proc.stderr
        errors = 0
        failures = 0
        tests_run = 0
        # Look for 'Ran N tests' line
        import re as _re
        m = _re.search(r"Ran (\d+) tests?", out)
        if m:
            tests_run = int(m.group(1))
        # Look for 'failures=N, errors=M'
        m2 = _re.search(r"failures=(\d+)", out)
        if m2: failures = int(m2.group(1))
        m3 = _re.search(r"errors=(\d+)", out)
        if m3: errors = int(m3.group(1))
        ok = (proc.returncode == 0) and (tests_run > 0)
        return {
            "errors": errors, "failures": failures, "testsRun": tests_run,
            "passed": ok, "reason": "ok" if ok else ("no_tests" if tests_run == 0 else "failed"),
        }


def evaluate_row(args):
    """One unit of work: (lang, model, iter_idx, method_id, generated_code, task, test_class)."""
    (lang, model, iter_idx, method_id, generated_code, task_id, method_name,
     solution_code, test_module_code, test_class_name) = args
    if not generated_code.strip():
        return {
            "language": lang, "model": model, "iteration": iter_idx,
            "id": method_id, "task_id": task_id, "method_name": method_name,
            "test_class": test_class_name,
            "errors": 0, "failures": 0, "testsRun": 0, "passed": False,
            "reason": "empty_generation",
        }

    # Splice the generated method into the ground-truth class
    spliced = replace_method(solution_code, method_name, generated_code)
    if spliced is None:
        return {
            "language": lang, "model": model, "iteration": iter_idx,
            "id": method_id, "task_id": task_id, "method_name": method_name,
            "test_class": test_class_name,
            "errors": 0, "failures": 0, "testsRun": 0, "passed": False,
            "reason": "splice_failed",
        }
    full_code = spliced + "\n\n" + test_module_code
    res = run_one_test({"task_id": task_id}, test_class_name, full_code)
    return {
        "language": lang, "model": model, "iteration": iter_idx,
        "id": method_id, "task_id": task_id, "method_name": method_name,
        "test_class": test_class_name,
        **res,
    }


def build_work_items(eval_data, method_tc, only_combo=None):
    work = []
    for lang in LANGUAGES:
        for model in MODELS:
            if only_combo and f"{lang}:{model}" != only_combo:
                continue
            src = sources_for(lang, model)
            if not src:
                continue
            for (iter_idx, csv_path, delim) in src:
                with open(csv_path, newline="", encoding="utf-8") as f:
                    for row in csv.DictReader(f, delimiter=delim):
                        mid = row.get("id") or ""
                        if "::" not in mid:
                            continue
                        task_id, method_name = mid.split("::", 1)
                        if task_id not in eval_data:
                            continue
                        test_class = method_tc.get((task_id, method_name))
                        if not test_class:
                            continue
                        solution = eval_data[task_id].get("solution_code", "")
                        test_mod = eval_data[task_id].get("test", "")
                        gen = (row.get("generated_code") or "").strip()
                        work.append((
                            lang, model, iter_idx, mid, gen,
                            task_id, method_name, solution, test_mod, test_class,
                        ))
    return work


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--workers", type=int, default=max(1, mp.cpu_count() - 1))
    ap.add_argument("--combo", default=None, help="Restrict to one lang:model pair, e.g. english:gpt")
    ap.add_argument("--limit", type=int, default=0, help="Process only first N items (for smoke tests)")
    ap.add_argument("--out", default=os.path.join(OUT_DIR, "classeval_test_results.csv"))
    args = ap.parse_args()

    eval_data, method_tc = load_classeval()
    work = build_work_items(eval_data, method_tc, only_combo=args.combo)
    if args.limit:
        work = work[: args.limit]
    print(f"Total work items: {len(work)}  workers={args.workers}")

    results = []
    if args.workers > 1:
        with mp.Pool(processes=args.workers) as pool:
            for i, r in enumerate(pool.imap_unordered(evaluate_row, work, chunksize=4), 1):
                results.append(r)
                if i % 500 == 0:
                    print(f"  progress: {i}/{len(work)} done")
    else:
        for i, w in enumerate(work, 1):
            results.append(evaluate_row(w))
            if i % 200 == 0:
                print(f"  progress: {i}/{len(work)} done")

    # Write CSV
    fields = ["language", "model", "iteration", "id", "task_id", "method_name",
              "test_class", "errors", "failures", "testsRun", "passed", "reason"]
    with open(args.out, "w", newline="") as f:
        w = csv.DictWriter(f, fieldnames=fields)
        w.writeheader()
        w.writerows(results)
    print(f"Wrote {args.out}  ({len(results)} rows)")


if __name__ == "__main__":
    main()
