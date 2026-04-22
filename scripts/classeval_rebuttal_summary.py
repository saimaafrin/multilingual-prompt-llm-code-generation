"""
Write a human-readable Markdown summary of the ClassEval rebuttal results.

Reads the aggregated artifacts produced by:
- classeval_qualitative_analysis.py   (classeval_table9.csv)
- classeval_quantitative_analysis.py  (classeval_metrics_summary.csv)
- classeval_stats.py                  (classeval_friedman_claude.csv, classeval_wilcoxon_claude.csv)

Writes:
- data/rebuttal/classeval_results/REBUTTAL_SUMMARY.md
"""

import csv
import os
from collections import defaultdict

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
RES = os.path.join(BASE, "data", "rebuttal", "classeval_results")
OUT = os.path.join(RES, "REBUTTAL_SUMMARY.md")

MODELS = ["gpt", "deepseek", "claude"]
LANGUAGES = ["chinese", "hindi", "spanish", "italian"]
LANG_SHORT = {"chinese": "C", "hindi": "H", "spanish": "S", "italian": "I"}


def load_csv(path):
    return list(csv.DictReader(open(path)))


def fmt_pct(v):
    try:
        return f"{float(v):.1f}"
    except Exception:
        return str(v)


def write_summary():
    qual = load_csv(os.path.join(RES, "classeval_table9.csv"))
    summ = load_csv(os.path.join(RES, "classeval_metrics_summary.csv"))
    fried = load_csv(os.path.join(RES, "classeval_friedman_claude.csv")) if os.path.exists(os.path.join(RES, "classeval_friedman_claude.csv")) else []
    wil = load_csv(os.path.join(RES, "classeval_wilcoxon_claude.csv")) if os.path.exists(os.path.join(RES, "classeval_wilcoxon_claude.csv")) else []

    lines = []
    lines.append("# ClassEval Rebuttal — Summary of Results")
    lines.append("")
    lines.append("This file summarizes the ClassEval replication of the CoderEval study used to "
                 "address reviewer comment 1.1. All numbers are derived directly from the CSV "
                 "artifacts in this directory; rerun the scripts in `scripts/` to reproduce.")
    lines.append("")
    lines.append("## Data coverage")
    lines.append("")
    lines.append("- **Benchmark**: ClassEval (100 classes, 410 methods)")
    lines.append("- **Natural languages**: English (baseline), Chinese, Hindi, Spanish, Italian")
    lines.append("- **Models**: GPT, DeepSeek, Claude")
    lines.append("- **Iterations**: Claude — 10 iterations per language (4100 methods per language). "
                 "GPT and DeepSeek — 1 iteration per language (from the manual-analysis sample).")
    lines.append("- **Programming language**: Python only — ClassEval has no Java split upstream.")
    lines.append("- **Static-analysis tools**: Lizard / Flake8 / Pylint. PMD is Java-only; SonarCloud "
                 "was dropped because on CoderEval it produced the same language orderings as "
                 "Pylint at comparable effect sizes.")
    lines.append("")

    # ===== Test pass rates =====
    pr_path = os.path.join(RES, "classeval_pass_rates.csv")
    if os.path.exists(pr_path):
        pr_rows = load_csv(pr_path)
        # Pivot: model → language → (pass_rate, n_passed, n_attempts)
        pr = defaultdict(dict)
        for r in pr_rows:
            pr[r["model"]][r["language"]] = (r["pass_rate_pct"], r["n_passed"], r["n_attempts"])
        lines.append("## Test pass rates")
        lines.append("")
        lines.append("Percentage of generated methods that pass ClassEval's unit tests. Each "
                     "generated method was spliced into the ground-truth class and evaluated "
                     "against the method-specific test class (e.g., `AccessGatewayFilterTestFilter`).")
        lines.append("")
        lines.append("| Model | English | Chinese | Hindi | Spanish | Italian |")
        lines.append("| --- | --- | --- | --- | --- | --- |")
        for model in MODELS:
            row = f"| {model} |"
            for lang in ["english"] + LANGUAGES:
                if lang in pr.get(model, {}):
                    rate, p, n = pr[model][lang]
                    row += f" {rate}% ({p}/{n}) |"
                else:
                    row += " N/A |"
            lines.append(row)
        lines.append("")
        lines.append("Per-iteration detail for Claude (10 iterations per language) is in "
                     "`classeval_pass_rates_by_iter.csv`.")
        lines.append("")

    # ===== McNemar for pass rates (same as CoderEval pipeline) =====
    mcn_path = os.path.join(RES, "classeval_test_mcnemar.csv")
    if os.path.exists(mcn_path):
        mcn_rows = load_csv(mcn_path)
        lines.append("### McNemar — English vs each target language (per model, paired on (iteration, method))")
        lines.append("")
        lines.append("Matches the `python-{model}-test.csv` output produced by the paper's R script "
                     "for CoderEval. Rows paired on (task, iteration); `b` counts cases where English "
                     "passed and the target language failed; `c` counts the reverse.")
        lines.append("")
        lines.append("| Model | Target | n pairs | passed Eng % | passed Lang % | b (E+, T−) | c (E−, T+) | p (BH) | Cohen's g | magnitude | sig. |")
        lines.append("| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |")
        for r in mcn_rows:
            lines.append(f"| {r['model']} | {r['language']} | {r['n_pairs']} | "
                         f"{r['passed_english_pct']} | {r['passed_lang_pct']} | "
                         f"{r['b_engPass_langFail']} | {r['c_engFail_langPass']} | "
                         f"{r['p_adj_BH']} | {r['cohens_g']} | {r['magnitude']} | {r['significant_0.05']} |")
        lines.append("")

    # ===== Qualitative =====
    lines.append("## Qualitative analysis (Table 9 equivalent)")
    lines.append("")
    lines.append("Percentage of methods (out of 410) whose comments / literals were written in the "
                 "indicated language. E = English, target = Chinese/Hindi/Spanish/Italian, "
                 "B = both.")
    lines.append("")

    for cat in ["comments", "literals"]:
        lines.append(f"### {cat.capitalize()}")
        lines.append("")
        head = "| Model |"
        sep = "| --- |"
        for lang in LANGUAGES:
            s = LANG_SHORT[lang]
            head += f" {lang.capitalize()} E | {lang.capitalize()} {s} | {lang.capitalize()} B |"
            sep += " --- | --- | --- |"
        lines.append(head)
        lines.append(sep)
        for model in MODELS:
            row = f"| {model} |"
            for lang in LANGUAGES:
                m = [r for r in qual if r["language"] == lang and r["model"] == model and r["category"] == cat]
                if m:
                    r = m[0]
                    row += f" {fmt_pct(r['english_pct'])} | {fmt_pct(r['target_pct'])} | {fmt_pct(r['both_pct'])} |"
                else:
                    row += " N/A | N/A | N/A |"
            lines.append(row)
        lines.append("")

    # ===== Quantitative =====
    lines.append("## Quantitative analysis (code metrics)")
    lines.append("")
    lines.append("Mean metric per (language, model). For Claude values are averaged across the 10 "
                 "iterations; for GPT / DeepSeek values come from the single iteration included in "
                 "the qualitative-analysis sample.")
    lines.append("")
    # Collapse across iterations
    by_lm = defaultdict(list)
    for r in summ:
        by_lm[(r["language"], r["model"])].append(r)
    lines.append("| Language | Model | n methods | mean nloc | mean ccn | mean tokens | mean length | mean top-nest | mean flake8 | mean pylint |")
    lines.append("| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |")
    for (lang, model), rows in sorted(by_lm.items()):
        ni = len(rows)
        n_methods = rows[0]["n_methods"]
        def mean_of(k):
            vals = [float(r[k]) for r in rows]
            return round(sum(vals) / ni, 2)
        lines.append(f"| {lang} | {model} | {n_methods} | {mean_of('mean_nloc')} | "
                     f"{mean_of('mean_ccn')} | {mean_of('mean_tokens')} | "
                     f"{mean_of('mean_length')} | {mean_of('mean_top_nesting')} | "
                     f"{mean_of('mean_flake8')} | {mean_of('mean_pylint')} |")
    lines.append("")

    # ===== Statistics =====
    if fried:
        lines.append("## Statistical tests (Claude, 10 iterations)")
        lines.append("")
        lines.append("### Friedman tests across the 5 languages (per metric, BH-adjusted p)")
        lines.append("")
        lines.append("| Metric | n paired rows | p-value | p (BH) | significant (α=0.05) |")
        lines.append("| --- | --- | --- | --- | --- |")
        for r in fried:
            lines.append(f"| {r['metric']} | {r['n_rows']} | {r['p_value']} | {r['p_adj_BH']} | {r['significant_0.05']} |")
        lines.append("")

    if wil:
        lines.append("### Wilcoxon: English vs target language (per metric, BH-adjusted p + Cliff's delta)")
        lines.append("")
        lines.append("| Metric | Target | n pairs | p-value | p (BH) | sig. | Cliff δ | magnitude |")
        lines.append("| --- | --- | --- | --- | --- | --- | --- | --- |")
        for r in wil:
            lines.append(f"| {r['metric']} | {r['language_vs_english']} | {r['n_pairs']} | "
                         f"{r['p_value']} | {r['p_adj_BH']} | {r['significant_0.05']} | "
                         f"{r['cliff_delta']} | {r['magnitude']} |")
        lines.append("")

    lines.append("## Files produced in this directory")
    lines.append("")
    lines.append("- `classeval_table9.csv` / `classeval_table9_wide.csv` — per-category, per-model, per-language counts and percentages.")
    lines.append("- `classeval_qualitative_summary.csv` — tidy version of Table 9.")
    lines.append("- `classeval_metrics_per_method.csv` — one row per (method, iteration, language, model) with Lizard / Flake8 / Pylint metrics.")
    lines.append("- `classeval_metrics_summary.csv` — mean metric per (language, model, iteration).")
    lines.append("- `classeval_python_{model}_report.csv` — wide per-method report mirroring `data/4_quantitative_analysis/python_{model}_report.csv` used by the R script.")
    lines.append("- `classeval_descriptive.csv` — mean + std per (language, model).")
    lines.append("- `classeval_friedman_claude.csv` / `classeval_wilcoxon_claude.csv` — statistical tests on Claude's 10 iterations.")
    lines.append("- `classeval_test_results.csv` — raw per-method test outcomes (errors/failures/testsRun/passed/reason).")
    lines.append("- `classeval_pass_rates.csv` / `classeval_pass_rates_by_iter.csv` — aggregated pass rates.")
    lines.append("- `classeval_failure_breakdown.csv` — counts of each failure reason per (language, model).")
    lines.append("- `classeval_test_mcnemar.csv` — McNemar + Cohen's g on (English vs target) pass/fail pairs (matches the `python-{model}-test.csv` file produced by the R script for CoderEval).")
    lines.append("")
    lines.append("## Caveats")
    lines.append("")
    lines.append("- **Programming-language scope**: ClassEval is Python-only upstream, so this extension replicates the CoderEval study only for Python. No equivalent Java class-level benchmark is available.")
    lines.append("- **Static-analysis scope**: PMD is Java-only and was therefore not applicable. SonarCloud was also skipped: in the CoderEval results, Pylint and SonarCloud produced consistent warning-count signals (same across-language orderings and comparable effect sizes), so running SonarCloud on ClassEval would have added no new information at the cost of the GitHub-Actions pipeline overhead. We therefore report only Lizard (size/complexity), Flake8 (style), and Pylint (warnings).")
    lines.append("- **Test-pass rates**: computed using the upstream `fudan-selab/ClassEval` benchmark data. Each generated method was spliced into the ground-truth class (keeping all other methods correct) and only the method-specific test class was run. A method is counted as 'passed' iff its test class reports zero errors and zero failures with at least one test executed. Generations that could not be spliced (mostly Claude outputs that omit the method signature) and those that timed out are counted as failures. Full per-attempt outcomes are in `classeval_test_results.csv`.")
    lines.append("- **Per-model iteration counts**: Claude has 10 iterations per language (matching the CoderEval protocol). GPT and DeepSeek have a single iteration per language (the one used for the manual qualitative labeling). Cross-language statistical tests are therefore reported for Claude only; GPT and DeepSeek are summarised descriptively.")
    lines.append("")
    with open(OUT, "w") as f:
        f.write("\n".join(lines))
    print(f"Wrote {OUT}")


if __name__ == "__main__":
    write_summary()
