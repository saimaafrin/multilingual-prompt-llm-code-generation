"""
Quantitative code-metric analysis for ClassEval (rebuttal).

Reuses the existing helpers from this repo:
- flake_analysis()  from flake_analysis.py
- pylint_analysis() from pylint_analysis.py
- lizard_analysis() from lizard_analysis.py
- create_dir()      from utils.py

Step 1 — materialize the CSV rebuttal data into the same on-disk layout these
helpers expect:
    ./data/rebuttal/classeval_generation/python_{language}_{model}/iter_{i}/files/{id}.py
(mirroring ./Data/generation/{prog_lang}_{language}_{model}/iter_{i}/files/ used for CoderEval)

Step 2 — call flake_analysis / lizard_analysis / pylint_analysis on each files/
directory, writing reports to iter_{i}/report/.

Step 3 — aggregate per-method metrics (from each iteration's lizard_analysis.csv +
the flake8/pylint reports) into a single classeval_metrics_per_method.csv plus a
summary classeval_metrics_summary.csv inside data/rebuttal/classeval_results/.

Data sources:
- Claude, 10 iterations: data/rebuttal/{lang}/{lang}_python_generated_code-{i}.csv
- GPT/DeepSeek, 1 iter:  data/classeval_manual_analysis/<subdir>/python_{lang}_{model}.csv
  (Spanish GPT is semicolon-separated; other files are standard CSV)
"""

import csv
import os
import sys

# Make sibling scripts importable
SCRIPTS_DIR = os.path.dirname(os.path.abspath(__file__))
sys.path.insert(0, SCRIPTS_DIR)

from flake_analysis import flake_analysis
# Use ClassEval variant of pylint wrapper (does not raise on non-zero exit,
# which is pylint's normal behavior whenever it reports issues).
from pylint_analysis_classeval import pylint_analysis
from lizard_analysis import lizard_analysis
from utils import create_dir

BASE = os.path.dirname(SCRIPTS_DIR)
REBUTTAL_DIR = os.path.join(BASE, "data", "rebuttal")
MANUAL_DIR = os.path.join(BASE, "data", "classeval_manual_analysis")
OUT_DIR = os.path.join(REBUTTAL_DIR, "classeval_results")
GEN_DIR = os.path.join(REBUTTAL_DIR, "classeval_generation")
create_dir(OUT_DIR)
create_dir(GEN_DIR)

MODELS = ["gpt", "deepseek", "claude"]
LANGUAGES = ["english", "chinese", "hindi", "spanish", "italian"]

# Per-iteration source for each (lang, model).
# Format: list of (iter_index, csv_path, delimiter)
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
    """Return list of (iter_idx, csv_path, delimiter) for this (lang, model)."""
    out = []
    if model == "claude":
        for i in range(10):
            p = os.path.join(REBUTTAL_DIR, lang, f"{lang}_python_generated_code-{i}.csv")
            if os.path.exists(p):
                out.append((i, p, ","))
        if out:
            return out
    # Fallback / non-Claude: single iteration from manual-analysis folder
    key = (lang, model)
    if key in MANUAL_MAP:
        rel, delim = MANUAL_MAP[key]
        p = os.path.join(MANUAL_DIR, rel)
        if os.path.exists(p):
            return [(0, p, delim)]
    return out


def safe_file_name(rid):
    """Make a task-id like 'ClassEval_0::filter' safe as a filename."""
    return rid.replace("::", "__").replace("/", "_")


def materialize(lang, model, src_list):
    """Write each method's generated_code to an individual .py file under GEN_DIR.

    Returns list of (iter_idx, files_dir, report_dir).
    """
    out = []
    for (iter_idx, csv_path, delim) in src_list:
        iter_dir = os.path.join(GEN_DIR, f"python_{lang}_{model}", f"iter_{iter_idx}")
        files_dir = os.path.join(iter_dir, "files")
        report_dir = os.path.join(iter_dir, "report")
        create_dir(files_dir)
        create_dir(report_dir)
        # Only write files if not already materialized (idempotent & fast for re-runs)
        existing = set(os.listdir(files_dir))
        with open(csv_path, newline="", encoding="utf-8") as f:
            for row in csv.DictReader(f, delimiter=delim):
                code = (row.get("generated_code") or "").strip()
                rid = row.get("id") or row.get("task_id") or ""
                if not code or not rid:
                    continue
                fname = safe_file_name(rid) + ".py"
                if fname in existing:
                    continue
                # Many ClassEval snippets are bare methods; wrap in a class so
                # static analyzers can parse them. The first line must be 'class _M:'.
                wrapped = "class _M:\n" + "\n".join("    " + ln for ln in code.splitlines())
                with open(os.path.join(files_dir, fname), "w", encoding="utf-8") as out_f:
                    out_f.write(wrapped)
        out.append((iter_idx, files_dir, report_dir))
    return out


def run_analyses(iter_dirs):
    for (iter_idx, files_dir, report_dir) in iter_dirs:
        # Lizard always
        try:
            lizard_analysis(files_dir, report_dir)
        except Exception as e:
            print(f"    lizard failed: {e}")
        # Flake8
        try:
            flake_analysis(files_dir, report_dir)
        except Exception as e:
            print(f"    flake8 failed: {e}")
        # Pylint
        try:
            pylint_analysis(files_dir, report_dir)
        except Exception as e:
            print(f"    pylint failed: {e}")


def aggregate(lang_model_iter_dirs):
    """Walk every iteration's lizard_analysis.csv / flake8_report.csv / pylint_report.csv
    and produce combined per-method + summary CSVs.
    """
    per_method = []
    summary = []

    for (lang, model, iter_idx, files_dir, report_dir) in lang_model_iter_dirs:
        liz_csv = os.path.join(report_dir, "lizard_analysis.csv")
        flake_csv = os.path.join(report_dir, "flake8_report.csv")
        pylint_csv = os.path.join(report_dir, "pylint_report.csv")

        # Load lizard
        liz_rows = {}
        if os.path.exists(liz_csv):
            with open(liz_csv) as f:
                for r in csv.DictReader(f):
                    liz_rows[r["filename"]] = r

        # Load flake8 counts by filename (full path)
        flake_counts = {}
        if os.path.exists(flake_csv):
            with open(flake_csv) as f:
                for r in csv.DictReader(f):
                    # filename here is a full path; use basename
                    fname = os.path.basename(r["filename"])
                    try:
                        flake_counts[fname] = int(r.get("count", 0))
                    except Exception:
                        flake_counts[fname] = 0

        # Load pylint counts by module name (basename without .py)
        pylint_counts = {}
        if os.path.exists(pylint_csv):
            with open(pylint_csv) as f:
                for r in csv.DictReader(f):
                    module = r.get("module", "")
                    try:
                        pylint_counts[module + ".py"] = int(r.get("count", 0))
                    except Exception:
                        pylint_counts[module + ".py"] = 0

        # Build per-method rows from the files actually in files_dir
        if not os.path.exists(files_dir):
            continue
        for fname in sorted(os.listdir(files_dir)):
            if not fname.endswith(".py"):
                continue
            rid = fname[:-3].replace("__", "::")
            liz = liz_rows.get(fname, {})
            try:
                nloc = int(liz.get("nloc", 0)) if liz else 0
                ccn = int(liz.get("ccn", 0)) if liz else 0
                tokens = int(liz.get("token_count", 0)) if liz else 0
                params = int(liz.get("param_count", 0)) if liz else 0
                length = int(liz.get("length", 0)) if liz else 0
                top = int(liz.get("top_nesting_level", 0)) if liz else 0
            except Exception:
                nloc = ccn = tokens = params = length = top = 0
            per_method.append({
                "language": lang, "model": model, "iteration": iter_idx, "id": rid,
                "nloc": nloc, "ccn": ccn, "token_count": tokens, "param_count": params,
                "length": length, "top_nesting_level": top,
                "flake8": flake_counts.get(fname, 0),
                "pylint": pylint_counts.get(fname, 0),
            })

    # Summary: mean per (lang, model, iter)
    from collections import defaultdict
    groups = defaultdict(list)
    for r in per_method:
        groups[(r["language"], r["model"], r["iteration"])].append(r)
    for (lang, model, it), rows in sorted(groups.items()):
        n = len(rows)
        if n == 0:
            continue
        mean = lambda k: round(sum(r[k] for r in rows) / n, 2)
        summary.append({
            "language": lang, "model": model, "iteration": it, "n_methods": n,
            "mean_nloc": mean("nloc"), "mean_ccn": mean("ccn"),
            "mean_tokens": mean("token_count"), "mean_length": mean("length"),
            "mean_top_nesting": mean("top_nesting_level"),
            "mean_flake8": mean("flake8"), "mean_pylint": mean("pylint"),
        })

    return per_method, summary


def main():
    # Track every (lang, model, iter) for aggregation
    all_iter_dirs = []

    for lang in LANGUAGES:
        for model in MODELS:
            src = sources_for(lang, model)
            if not src:
                print(f"{lang} {model}: no source CSVs found, skipping")
                continue
            print(f"{lang} {model}: {len(src)} iteration(s)")
            iter_dirs = materialize(lang, model, src)
            run_analyses(iter_dirs)
            for (it, files_dir, report_dir) in iter_dirs:
                all_iter_dirs.append((lang, model, it, files_dir, report_dir))

    per_method, summary = aggregate(all_iter_dirs)

    per_path = os.path.join(OUT_DIR, "classeval_metrics_per_method.csv")
    with open(per_path, "w", newline="") as f:
        writer = csv.DictWriter(f, fieldnames=list(per_method[0].keys()))
        writer.writeheader()
        writer.writerows(per_method)
    print(f"Wrote {per_path} ({len(per_method)} rows)")

    sum_path = os.path.join(OUT_DIR, "classeval_metrics_summary.csv")
    with open(sum_path, "w", newline="") as f:
        writer = csv.DictWriter(f, fieldnames=list(summary[0].keys()))
        writer.writeheader()
        writer.writerows(summary)
    print(f"Wrote {sum_path} ({len(summary)} rows)")


if __name__ == "__main__":
    main()
