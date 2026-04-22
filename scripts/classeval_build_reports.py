"""
Build ClassEval summary reports analogous to data/4_quantitative_analysis/python_*_report.csv.

Inputs:
- data/rebuttal/classeval_results/classeval_metrics_per_method.csv   (from classeval_quantitative_analysis.py)
- data/rebuttal/classeval_results/classeval_table9.csv               (from classeval_qualitative_analysis.py)

Outputs (data/rebuttal/classeval_results/):
- classeval_python_{model}_report.csv   — wide per-method-metrics file per model,
  matching the column layout of data/4_quantitative_analysis/python_{model}_report.csv
  (one row per (id, iter), columns prefixed with {language}_{metric})
- classeval_qualitative_summary.csv     — tidy summary of Table 9 equivalent
"""

import csv
import os
from collections import defaultdict

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
IN_DIR = os.path.join(BASE, "data", "rebuttal", "classeval_results")
OUT_DIR = IN_DIR

MODELS = ["gpt", "deepseek", "claude"]
LANGUAGES = ["italian", "english", "chinese", "hindi", "spanish"]
METRIC_COLS = ["nloc", "ccn", "token_count", "param_count", "length", "top_nesting_level", "flake8", "pylint"]


def build_wide_metrics():
    per_path = os.path.join(IN_DIR, "classeval_metrics_per_method.csv")
    rows = []
    with open(per_path) as f:
        rows = list(csv.DictReader(f))

    # Group: (model) -> (id, iter) -> language -> metric dict
    data = defaultdict(lambda: defaultdict(dict))
    for r in rows:
        key_outer = r["model"]
        key_mid = (r["id"], int(r["iteration"]))
        data[key_outer][key_mid][r["language"]] = r

    for model in MODELS:
        out_path = os.path.join(OUT_DIR, f"classeval_python_{model}_report.csv")
        # Header
        header = ["id", "iter"]
        for lang in LANGUAGES:
            for m in METRIC_COLS:
                header.append(f"{lang}_{m}")

        # All (id, iter) pairs that show up for this model
        all_ids = sorted(data[model].keys())

        with open(out_path, "w", newline="") as f:
            writer = csv.writer(f)
            writer.writerow(header)
            for (rid, it) in all_ids:
                row = [rid, it]
                langs_for_row = data[model][(rid, it)]
                for lang in LANGUAGES:
                    mrow = langs_for_row.get(lang)
                    for m in METRIC_COLS:
                        if mrow is None:
                            row.append("")
                        else:
                            row.append(mrow.get(m, ""))
                writer.writerow(row)
        print(f"Wrote {out_path} ({len(all_ids)} rows)")


def build_qualitative_summary():
    in_path = os.path.join(IN_DIR, "classeval_table9.csv")
    rows = list(csv.DictReader(open(in_path)))
    out_path = os.path.join(OUT_DIR, "classeval_qualitative_summary.csv")
    # Same as input but reshaped to one row per (language, model) with separate E/T/B columns per category
    tidy = defaultdict(dict)
    for r in rows:
        key = (r["language"], r["model"])
        cat = r["category"]
        tidy[key][f"{cat}_E"] = r["english_pct"]
        tidy[key][f"{cat}_T"] = r["target_pct"]
        tidy[key][f"{cat}_B"] = r["both_pct"]
        tidy[key][f"{cat}_none"] = r["none_pct"]
        tidy[key][f"{cat}_other"] = r["other_pct"]
        tidy[key]["total_methods"] = r["total_methods"]
    header = ["language", "model", "total_methods"]
    for cat in ["comments", "identifiers", "literals"]:
        for suf in ["E", "T", "B", "none", "other"]:
            header.append(f"{cat}_{suf}")
    with open(out_path, "w", newline="") as f:
        writer = csv.writer(f)
        writer.writerow(header)
        for key in sorted(tidy.keys()):
            lang, model = key
            row = [lang, model, tidy[key]["total_methods"]]
            for cat in ["comments", "identifiers", "literals"]:
                for suf in ["E", "T", "B", "none", "other"]:
                    row.append(tidy[key].get(f"{cat}_{suf}", ""))
            writer.writerow(row)
    print(f"Wrote {out_path}")


def print_rebuttal_tables():
    """Print the rebuttal-ready table to stdout — Table 9 equivalent + metric summary."""
    # Qualitative table
    print("=" * 110)
    print("ClassEval Table 9 equivalent — percentages of methods (out of 410)")
    print("=" * 110)
    qual = list(csv.DictReader(open(os.path.join(IN_DIR, "classeval_table9.csv"))))
    for cat in ["comments", "literals"]:
        print(f"\n{cat.upper()}")
        print(f"{'Model':<10} | " + " | ".join(f"{l.capitalize():>17}" for l in ["chinese","hindi","spanish","italian"]))
        print(f"{'':10s} | " + " | ".join(f"{'E / T / B':>17}" for _ in range(4)))
        print("-" * 100)
        for model in MODELS:
            row = f"  {model:<8} | "
            parts = []
            for lang in ["chinese", "hindi", "spanish", "italian"]:
                m = [r for r in qual if r["language"] == lang and r["model"] == model and r["category"] == cat]
                if m:
                    r = m[0]
                    parts.append(f"{r['english_pct']:>5}/{r['target_pct']:>5}/{r['both_pct']:>4}")
                else:
                    parts.append(f"{'N/A':>17}")
            print(row + " | ".join(parts))

    # Metrics summary
    print()
    print("=" * 110)
    print("ClassEval metric summary — mean per (language, model). Claude: mean across 10 iters; GPT/DS: 1 iter.")
    print("=" * 110)
    summ = list(csv.DictReader(open(os.path.join(IN_DIR, "classeval_metrics_summary.csv"))))
    # For Claude, average across iterations
    from collections import defaultdict
    by_lm = defaultdict(list)
    for r in summ:
        by_lm[(r["language"], r["model"])].append(r)

    fields = ["n_methods", "mean_nloc", "mean_ccn", "mean_tokens", "mean_length", "mean_top_nesting", "mean_flake8", "mean_pylint"]
    header = f"{'language':<9} {'model':<10}" + "".join(f" {f:>16}" for f in fields)
    print(header)
    print("-" * len(header))
    for (lang, model), rows in sorted(by_lm.items()):
        n_iter = len(rows)
        n_methods = rows[0]["n_methods"]
        means = {f: round(sum(float(r[f]) for r in rows) / n_iter, 2) for f in fields if f != "n_methods"}
        means["n_methods"] = n_methods
        out = f"{lang:<9} {model:<10}"
        for f in fields:
            out += f" {str(means[f]):>16}"
        print(out)


if __name__ == "__main__":
    build_wide_metrics()
    build_qualitative_summary()
    print_rebuttal_tables()
