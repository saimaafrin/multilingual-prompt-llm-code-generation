"""
Aggregate ClassEval method-level test results into per-(language, model) pass rates.

Reads:
  data/rebuttal/classeval_results/classeval_test_results.csv   (from classeval_run_tests.py)

Writes:
  data/rebuttal/classeval_results/classeval_pass_rates.csv     — one row per
    (language, model) with pass rate and counts.
  data/rebuttal/classeval_results/classeval_pass_rates_by_iter.csv — one row
    per (language, model, iteration) for Claude's 10-iteration detail.
  data/rebuttal/classeval_results/classeval_failure_breakdown.csv — counts of
    each failure reason per (language, model).
"""

import csv
import os
from collections import defaultdict

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
RES_DIR = os.path.join(BASE, "data", "rebuttal", "classeval_results")
IN_PATH = os.path.join(RES_DIR, "classeval_test_results.csv")


def load():
    rows = list(csv.DictReader(open(IN_PATH)))
    for r in rows:
        r["passed"] = r["passed"] == "True"
        try:
            r["iteration"] = int(r["iteration"])
        except Exception:
            r["iteration"] = 0
    return rows


def pct(n, d):
    return round(100.0 * n / d, 2) if d > 0 else 0.0


def main():
    rows = load()
    # Per (lang, model)
    by_lm = defaultdict(list)
    by_lmi = defaultdict(list)
    reason_counts = defaultdict(lambda: defaultdict(int))

    for r in rows:
        key_lm = (r["language"], r["model"])
        key_lmi = (r["language"], r["model"], r["iteration"])
        by_lm[key_lm].append(r)
        by_lmi[key_lmi].append(r)
        reason_counts[key_lm][r["reason"]] += 1

    # --- Per (lang, model) summary ---
    path1 = os.path.join(RES_DIR, "classeval_pass_rates.csv")
    with open(path1, "w", newline="") as f:
        w = csv.writer(f)
        w.writerow(["language", "model", "n_attempts", "n_passed", "pass_rate_pct"])
        for key in sorted(by_lm):
            rs = by_lm[key]
            n = len(rs)
            p = sum(1 for r in rs if r["passed"])
            w.writerow([key[0], key[1], n, p, pct(p, n)])
    print(f"Wrote {path1}")

    # --- Per (lang, model, iteration) detail ---
    path2 = os.path.join(RES_DIR, "classeval_pass_rates_by_iter.csv")
    with open(path2, "w", newline="") as f:
        w = csv.writer(f)
        w.writerow(["language", "model", "iteration", "n_attempts", "n_passed", "pass_rate_pct"])
        for key in sorted(by_lmi):
            rs = by_lmi[key]
            n = len(rs)
            p = sum(1 for r in rs if r["passed"])
            w.writerow([key[0], key[1], key[2], n, p, pct(p, n)])
    print(f"Wrote {path2}")

    # --- Failure reason breakdown ---
    path3 = os.path.join(RES_DIR, "classeval_failure_breakdown.csv")
    reasons = sorted({r for d in reason_counts.values() for r in d})
    with open(path3, "w", newline="") as f:
        w = csv.writer(f)
        w.writerow(["language", "model"] + reasons)
        for key in sorted(reason_counts):
            row = [key[0], key[1]]
            for reason in reasons:
                row.append(reason_counts[key].get(reason, 0))
            w.writerow(row)
    print(f"Wrote {path3}")

    # --- Pretty-print summary ---
    print()
    print("=" * 80)
    print("ClassEval test pass rates — % of generated methods that pass the unit tests")
    print("=" * 80)
    print(f"{'Model':<10} | " + " | ".join(f"{l.capitalize():>10}" for l in ["english","chinese","hindi","spanish","italian"]))
    print("-" * 80)
    for model in ["gpt", "deepseek", "claude"]:
        row = f"  {model:<8} |"
        for lang in ["english","chinese","hindi","spanish","italian"]:
            rs = by_lm.get((lang, model), [])
            if rs:
                n = len(rs)
                p = sum(1 for r in rs if r["passed"])
                row += f" {pct(p,n):>4.1f}% ({p}/{n:>4}) |"
            else:
                row += f" {'N/A':>10} |"
        print(row)


if __name__ == "__main__":
    main()
