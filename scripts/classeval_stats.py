"""
Statistical tests for ClassEval (rebuttal).

Mirrors the core tests from scripts/multilingual-script.R for the ClassEval data.
Only Claude has 10 iterations (suitable for Friedman with iter as block), so
Friedman / Wilcoxon tests run on Claude; for GPT and DeepSeek (1 iteration each)
we only report descriptive statistics.

Tests run for Claude:
- Per metric, one Friedman test across 5 languages (iter as block, id as strata) → p-value
- Pairwise Wilcoxon signed-rank (english vs each other language) → p-value + Cliff's delta

Inputs:
- data/rebuttal/classeval_results/classeval_metrics_per_method.csv

Outputs (data/rebuttal/classeval_results/):
- classeval_friedman_claude.csv      — per-metric Friedman test (BH-adjusted p)
- classeval_wilcoxon_claude.csv      — english vs each lang per metric (BH-adjusted p + Cliff delta)
- classeval_descriptive.csv          — mean + std per (language, model, metric)
"""

import csv
import os
from collections import defaultdict
from statistics import mean, stdev

from scipy.stats import friedmanchisquare, wilcoxon

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
IN_DIR = os.path.join(BASE, "data", "rebuttal", "classeval_results")

METRICS = ["nloc", "ccn", "token_count", "length", "top_nesting_level", "flake8", "pylint"]
LANGUAGES_ORDER = ["english", "chinese", "hindi", "spanish", "italian"]
NON_ENGLISH = ["chinese", "hindi", "spanish", "italian"]


def cliff_delta(xs, ys):
    """Cliff's delta effect size between two paired samples."""
    if not xs or not ys:
        return 0.0, "negligible"
    n = 0
    tot = len(xs) * len(ys)
    for x in xs:
        for y in ys:
            if x > y:
                n += 1
            elif x < y:
                n -= 1
    d = n / tot if tot else 0.0
    ad = abs(d)
    if ad < 0.147: mag = "negligible"
    elif ad < 0.33: mag = "small"
    elif ad < 0.474: mag = "medium"
    else: mag = "large"
    return round(d, 4), mag


def bh_adjust(pvalues):
    """Benjamini–Hochberg FDR adjustment. Returns list of same order."""
    n = len(pvalues)
    indexed = sorted(enumerate(pvalues), key=lambda x: x[1])
    adj = [0.0] * n
    prev = 1.0
    for rank, (i, p) in enumerate(reversed(indexed), 1):
        k = n - rank + 1
        q = p * n / k
        q = min(q, prev)
        prev = q
        adj[i] = min(q, 1.0)
    return adj


def load():
    per_path = os.path.join(IN_DIR, "classeval_metrics_per_method.csv")
    rows = list(csv.DictReader(open(per_path)))
    # Cast numeric metrics
    for r in rows:
        r["iteration"] = int(r["iteration"])
        for m in METRICS:
            try:
                r[m] = float(r[m]) if r[m] != "" else 0.0
            except (ValueError, KeyError):
                r[m] = 0.0
    return rows


def descriptive(rows, out_path):
    by = defaultdict(list)
    for r in rows:
        key = (r["language"], r["model"])
        by[key].append(r)
    with open(out_path, "w", newline="") as f:
        writer = csv.writer(f)
        writer.writerow(["language", "model", "n"] + [f"{m}_mean" for m in METRICS] + [f"{m}_std" for m in METRICS])
        for key in sorted(by.keys()):
            rs = by[key]
            row = [key[0], key[1], len(rs)]
            for m in METRICS:
                vals = [r[m] for r in rs]
                row.append(round(mean(vals), 3) if vals else "")
            for m in METRICS:
                vals = [r[m] for r in rs]
                row.append(round(stdev(vals), 3) if len(vals) > 1 else "")
            writer.writerow(row)
    print(f"Wrote {out_path}")


def friedman_claude(rows, out_path):
    """Per metric, Friedman test across 5 languages, strata = (iter, id)."""
    claude_rows = [r for r in rows if r["model"] == "claude"]
    # Build wide: (iter, id) -> {lang: metric}
    pvals = []
    metric_order = []
    for m in METRICS:
        wide = defaultdict(dict)
        for r in claude_rows:
            wide[(r["iteration"], r["id"])][r["language"]] = r[m]
        # Keep only keys with all 5 languages
        complete = [v for v in wide.values() if all(l in v for l in LANGUAGES_ORDER)]
        if len(complete) < 2:
            pvals.append(1.0)
            metric_order.append((m, 0))
            continue
        samples = [[d[l] for d in complete] for l in LANGUAGES_ORDER]
        try:
            stat, p = friedmanchisquare(*samples)
        except Exception:
            p = 1.0
        pvals.append(p)
        metric_order.append((m, len(complete)))

    adj = bh_adjust(pvals)
    with open(out_path, "w", newline="") as f:
        writer = csv.writer(f)
        writer.writerow(["metric", "n_rows", "p_value", "p_adj_BH", "significant_0.05"])
        for (m, n_rows), p, pa in zip(metric_order, pvals, adj):
            writer.writerow([m, n_rows, round(p, 6), round(pa, 6), pa < 0.05])
    print(f"Wrote {out_path}")


def wilcoxon_claude(rows, out_path):
    """English vs each other language, per metric. Paired on (iter, id)."""
    claude_rows = [r for r in rows if r["model"] == "claude"]
    # Build: (iter, id) -> lang -> metric value
    wide = defaultdict(dict)
    for r in claude_rows:
        wide[(r["iteration"], r["id"])][r["language"]] = r

    triples = []  # (metric, language, p, d, mag, n)
    pvals = []
    for m in METRICS:
        for lang in NON_ENGLISH:
            xs, ys = [], []
            for d in wide.values():
                if "english" in d and lang in d:
                    xs.append(d["english"][m])
                    ys.append(d[lang][m])
            if len(xs) < 5:
                p = 1.0
            else:
                try:
                    _, p = wilcoxon(xs, ys)
                except Exception:
                    p = 1.0
            delta, mag = cliff_delta(ys, xs)
            triples.append((m, lang, p, delta, mag, len(xs)))
            pvals.append(p)

    adj = bh_adjust(pvals)
    with open(out_path, "w", newline="") as f:
        writer = csv.writer(f)
        writer.writerow(["metric", "language_vs_english", "n_pairs", "p_value", "p_adj_BH", "significant_0.05", "cliff_delta", "magnitude"])
        for (m, lang, p, d, mag, n), pa in zip(triples, adj):
            writer.writerow([m, lang, n, round(p, 6), round(pa, 6), pa < 0.05, d, mag])
    print(f"Wrote {out_path}")


def main():
    rows = load()
    descriptive(rows, os.path.join(IN_DIR, "classeval_descriptive.csv"))
    friedman_claude(rows, os.path.join(IN_DIR, "classeval_friedman_claude.csv"))
    wilcoxon_claude(rows, os.path.join(IN_DIR, "classeval_wilcoxon_claude.csv"))


if __name__ == "__main__":
    main()
