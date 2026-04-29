"""
Upstream-style pass@k evaluation for ClassEval (rebuttal).

Faithful port of:
- /tmp/ClassEval/classeval_evaluation/test_pipeline.py::cal_pass_at_k
- /tmp/ClassEval/classeval_evaluation/test_pipeline.py::cal_metrics_pass_at_k
- /tmp/ClassEval/classeval_evaluation/test_pipeline.py::get_test_answer
- /tmp/ClassEval/classeval_evaluation/test_pipeline.py::evaluate

Per-sample classification (from get_test_answer):
    - 'error'           : testsRun == 0 OR errors == testsRun
                          (also: splice_failed / timeout / empty_generation)
    - 'success'         : errors + failures == 0 (and testsRun > 0)
    - 'partial_success' : 0 < errors + failures < testsRun
    - 'fail'            : errors + failures == testsRun and at least one is a failure

For each method's test_class we count over K samples:
    success           = number of samples classified as 'success'
    partial_success   = number of samples classified as 'partial_success'
For each class we aggregate across its test_classes (one per method):
    class_success           +=1 iff every test_class in the sample is 'success'
    class_partial_success   +=1 iff every test_class is 'success' or 'partial_success'

Then unbiased pass@n (Chen et al. / HumanEval) over k samples:
    pass@n = 1 - C(k - k_success, n) / C(k, n)            if k - k_success >= n
           = 1                                            otherwise

Final reported metrics (averaged across all methods / all classes):
    fun_success            (strict per-method)
    fun_partial_success    (per-method, partial OK)
    class_success          (strict per-class)
    class_partial_success  (per-class, partial OK)

Inputs:
  data/rebuttal/classeval_results/classeval_test_results.csv

Outputs (data/rebuttal/classeval_results/):
  classeval_pass_at_k_upstream.csv         per (lang, model, n) — 4 metrics + sample size k
  classeval_pass_at_k_upstream_summary.txt human-readable table
"""

from math import comb
import csv
import os
from collections import defaultdict

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
RES_DIR = os.path.join(BASE, "data", "rebuttal", "classeval_results")
IN_PATH = os.path.join(RES_DIR, "classeval_test_results.csv")

MODELS = ["gpt", "deepseek", "claude"]
LANGUAGES = ["english", "chinese", "hindi", "spanish", "italian"]


def classify(sample):
    """ClassEval get_test_answer logic.
    sample is a row dict with errors, failures, testsRun, reason.
    """
    if sample["reason"] in ("timeout", "splice_failed", "empty_generation", "runner_error"):
        return "error"
    tr = sample["testsRun"]
    e = sample["errors"]
    f = sample["failures"]
    if tr == 0 or e == tr:
        return "error"
    if e + f == 0:
        return "success"
    if e + f < tr:
        return "partial_success"
    return "fail"


def cal_pass_at_k(n, k, k_success):
    """Chen et al. unbiased pass@n estimator over k samples."""
    if k_success == 0:
        return 0.0
    if k - k_success < n:
        # All n-subsets contain at least one success
        return 1.0
    total = comb(k, n)
    without = comb(k - k_success, n)
    return 1.0 - without / total


def load():
    rows = list(csv.DictReader(open(IN_PATH)))
    for r in rows:
        for k in ("errors", "failures", "testsRun"):
            try:
                r[k] = int(r[k])
            except Exception:
                r[k] = 0
        try:
            r["iteration"] = int(r["iteration"])
        except Exception:
            r["iteration"] = 0
        r["passed"] = r["passed"] == "True"
        r["answer"] = classify(r)
    return rows


def aggregate_for_model_lang(rows, model, lang):
    """Build classification counts per (task_id, method_name) over all K samples
    for this (model, lang). Mirrors the per-test_class success/partial_success
    counts in upstream evaluate()."""
    # method_results[(task_id, method_name)] = list of 'success'/... per sample
    method_results = defaultdict(list)
    for r in rows:
        if r["model"] != model or r["language"] != lang:
            continue
        method_results[(r["task_id"], r["method_name"])].append(r["answer"])
    # Group methods by class
    methods_by_class = defaultdict(list)
    for (task_id, mname), answers in method_results.items():
        methods_by_class[task_id].append((mname, answers))
    return method_results, methods_by_class


def compute_metrics(method_results, methods_by_class, n, k):
    """Reimplementation of cal_metrics_pass_at_k for one (model, lang).

    Returns dict with: fun_success, fun_partial_success,
                       class_success, class_partial_success.
    """
    # Method-level
    sum_num = len(method_results)
    success_num = 0.0
    partial_num = 0.0
    for (task_id, mname), answers in method_results.items():
        s = sum(1 for a in answers if a == "success")
        ps = s + sum(1 for a in answers if a == "partial_success")
        if s > 0:
            success_num += cal_pass_at_k(n, k, s)
        if ps > 0:
            partial_num += cal_pass_at_k(n, k, ps)

    # Class-level
    class_num = len(methods_by_class)
    class_success_num = 0.0
    class_partial_num = 0.0
    for task_id, methods in methods_by_class.items():
        # For each sample i in 0..k-1, is the entire class 'success'? 'partial_success'?
        # All methods must be at least 'success' (or 'partial_success') in sample i.
        n_strict = 0
        n_partial = 0
        for i in range(k):
            answers_i = [answers[i] if i < len(answers) else "error" for (_, answers) in methods]
            if all(a == "success" for a in answers_i):
                n_strict += 1
            if all(a in ("success", "partial_success") for a in answers_i):
                n_partial += 1
        if n_strict > 0:
            class_success_num += cal_pass_at_k(n, k, n_strict)
        if n_partial > 0:
            class_partial_num += cal_pass_at_k(n, k, n_partial)

    return {
        "fun_success": success_num / sum_num if sum_num else 0.0,
        "fun_partial_success": partial_num / sum_num if sum_num else 0.0,
        "class_success": class_success_num / class_num if class_num else 0.0,
        "class_partial_success": class_partial_num / class_num if class_num else 0.0,
    }


def main():
    rows = load()
    out_rows = []

    for model in MODELS:
        # Determine k from the data — Claude has 10 iters, GPT/DS have 1
        ks = sorted({r["iteration"] for r in rows if r["model"] == model}) if rows else []
        k = max(ks) + 1 if ks else 0
        if k == 0:
            continue
        # n values to report: subsets of [1,3,5,10] that are <= k
        ns = [n for n in (1, 3, 5, 10) if n <= k]

        for lang in LANGUAGES:
            method_results, methods_by_class = aggregate_for_model_lang(rows, model, lang)
            if not method_results:
                continue
            for n in ns:
                metrics = compute_metrics(method_results, methods_by_class, n, k)
                out_rows.append({
                    "language": lang, "model": model, "k_samples": k, "n": n,
                    "fun_success": round(metrics["fun_success"], 4),
                    "fun_partial_success": round(metrics["fun_partial_success"], 4),
                    "class_success": round(metrics["class_success"], 4),
                    "class_partial_success": round(metrics["class_partial_success"], 4),
                })

    # Write CSV
    out_csv = os.path.join(RES_DIR, "classeval_pass_at_k_upstream.csv")
    fields = ["language", "model", "k_samples", "n",
              "fun_success", "fun_partial_success",
              "class_success", "class_partial_success"]
    with open(out_csv, "w", newline="") as f:
        w = csv.DictWriter(f, fieldnames=fields)
        w.writeheader(); w.writerows(out_rows)
    print(f"Wrote {out_csv}")

    # Pretty summary
    out_txt = os.path.join(RES_DIR, "classeval_pass_at_k_upstream_summary.txt")
    lines = []
    lines.append("ClassEval upstream pass@n  (k = number of samples per task; n = pass@n)")
    lines.append("All values are fractions in [0,1]. Multiply by 100 for percentages.\n")
    for model in MODELS:
        lines.append(f"=== {model} ===")
        rs = [r for r in out_rows if r["model"] == model]
        if not rs:
            lines.append("  (no data)\n"); continue
        ns = sorted({r["n"] for r in rs})
        k = rs[0]["k_samples"]
        for metric in ("fun_success", "fun_partial_success", "class_success", "class_partial_success"):
            lines.append(f"  {metric}  (k={k})")
            header = f"    {'language':<10}" + "".join(f"  pass@{n:<3}" for n in ns)
            lines.append(header)
            for lang in LANGUAGES:
                lr = [r for r in rs if r["language"] == lang]
                if not lr: continue
                row = f"    {lang:<10}" + "".join(f"  {[r[metric] for r in lr if r['n']==n][0]:.4f}" for n in ns)
                lines.append(row)
            lines.append("")
        lines.append("")
    with open(out_txt, "w") as f:
        f.write("\n".join(lines))
    print(f"Wrote {out_txt}")
    print()
    print("\n".join(lines))


if __name__ == "__main__":
    main()
