"""
Class-level pass rates for ClassEval (rebuttal).

The method-level results in classeval_test_results.csv tell us, for each
(method, iteration, language, model), whether the generated method passes
its dedicated test class. This script aggregates those into the
**class-level** view used by the upstream ClassEval benchmark:

  A class "passes" in iteration i (for a given language and model) iff
  every one of its methods passes in iteration i.

We also compute the looser "class_partial_success" variant (every method's
test class either fully passes or only fails — i.e., no errors / runtime
crashes), mirroring the upstream `class_partial_success` field.

Inputs:
  data/rebuttal/classeval_results/classeval_test_results.csv

Outputs (data/rebuttal/classeval_results/):
  classeval_class_level_pass_rates.csv         per (lang, model) class-level rate
  classeval_class_level_pass_rates_by_iter.csv per (lang, model, iter) detail
"""

import csv
import os
from collections import defaultdict

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
RES_DIR = os.path.join(BASE, "data", "rebuttal", "classeval_results")
IN_PATH = os.path.join(RES_DIR, "classeval_test_results.csv")

MODELS = ["gpt", "deepseek", "claude"]
LANGUAGES = ["english", "chinese", "hindi", "spanish", "italian"]


def load():
    rows = list(csv.DictReader(open(IN_PATH)))
    for r in rows:
        r["passed"] = r["passed"] == "True"
        try:
            r["iteration"] = int(r["iteration"])
        except Exception:
            r["iteration"] = 0
        # error/failure counts are integers
        for k in ("errors", "failures", "testsRun"):
            try:
                r[k] = int(r[k])
            except Exception:
                r[k] = 0
    return rows


def pct(n, d):
    return round(100.0 * n / d, 2) if d > 0 else 0.0


def main():
    rows = load()

    # Index: (lang, model, iter, task_id) -> list of method-rows for that class
    by_class_iter = defaultdict(list)
    for r in rows:
        by_class_iter[(r["language"], r["model"], r["iteration"], r["task_id"])].append(r)

    # Per-iter aggregation
    by_iter_rows = []  # one row per (lang, model, iter)
    by_lm_totals = defaultdict(lambda: {"strict_pass": 0, "partial_pass": 0, "n_classes": 0})

    iter_groups = defaultdict(lambda: defaultdict(list))
    for (lang, model, it, task), methods in by_class_iter.items():
        iter_groups[(lang, model, it)][task] = methods

    for (lang, model, it), tasks in sorted(iter_groups.items()):
        n_classes = len(tasks)
        strict = 0
        partial = 0
        for task_id, ms in tasks.items():
            all_strict = all(m["passed"] for m in ms)
            # 'partial' = no method had errors (testsRun > 0 AND errors == 0)
            #            i.e. tests all ran cleanly even if some assertions failed.
            no_errors = all((m["testsRun"] > 0 and m["errors"] == 0) for m in ms)
            if all_strict:
                strict += 1
            if no_errors:
                partial += 1
        by_iter_rows.append({
            "language": lang, "model": model, "iteration": it,
            "n_classes": n_classes,
            "class_strict_pass": strict,
            "class_partial_pass": partial,
            "class_strict_pct": pct(strict, n_classes),
            "class_partial_pct": pct(partial, n_classes),
        })
        by_lm_totals[(lang, model)]["strict_pass"] += strict
        by_lm_totals[(lang, model)]["partial_pass"] += partial
        by_lm_totals[(lang, model)]["n_classes"] += n_classes

    # Write per-iter detail
    out2 = os.path.join(RES_DIR, "classeval_class_level_pass_rates_by_iter.csv")
    with open(out2, "w", newline="") as f:
        w = csv.DictWriter(f, fieldnames=list(by_iter_rows[0].keys()))
        w.writeheader(); w.writerows(by_iter_rows)
    print(f"Wrote {out2}")

    # Write per (lang, model) summary
    out1 = os.path.join(RES_DIR, "classeval_class_level_pass_rates.csv")
    with open(out1, "w", newline="") as f:
        w = csv.writer(f)
        w.writerow(["language", "model", "n_class_attempts",
                    "class_strict_pass", "class_partial_pass",
                    "class_strict_rate_pct", "class_partial_rate_pct"])
        for key in sorted(by_lm_totals):
            t = by_lm_totals[key]
            w.writerow([
                key[0], key[1], t["n_classes"],
                t["strict_pass"], t["partial_pass"],
                pct(t["strict_pass"], t["n_classes"]),
                pct(t["partial_pass"], t["n_classes"]),
            ])
    print(f"Wrote {out1}")

    # Pretty print
    print()
    print("=" * 90)
    print("ClassEval class-level pass rates  (a class passes iff EVERY method passes)")
    print("=" * 90)
    print(f"{'Model':<10} | " + " | ".join(f"{l.capitalize():>14}" for l in LANGUAGES))
    print(f"{'(strict)':<10} | " + " | ".join(f"{'pass / classes':>14}" for _ in LANGUAGES))
    print("-" * 90)
    for model in MODELS:
        row = f"  {model:<8} |"
        for lang in LANGUAGES:
            t = by_lm_totals.get((lang, model))
            if t:
                row += f" {pct(t['strict_pass'], t['n_classes']):>5.1f}% ({t['strict_pass']:>3}/{t['n_classes']:>4}) |"
            else:
                row += f" {'N/A':>14} |"
        print(row)


if __name__ == "__main__":
    main()
