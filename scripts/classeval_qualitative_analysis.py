
"""
Qualitative analysis for ClassEval benchmark (rebuttal).

Produces the ClassEval equivalent of Table 9 in the paper: per-method counts
and percentages of comments / identifiers / literals written in English (E),
the target language (C/H/S/I), or both (B).

Inputs (per model/language combination):
- Chinese:  classeval_manual_analysis/Chinese_labeled/python_chinese_{model}.csv
            (claude uses python_chinese_claude_fixed.csv)
- Italian:  classeval_manual_analysis/italian-manual-analysis/python_italian_{model}.csv
- Spanish:  classeval_manual_analysis/spanish-manual-analysis/python_spanish_{model}.csv
            (gpt file is semicolon-separated; claude/deepseek converted from .numbers)
- Hindi:    classeval_manual_analysis/hindi-manually-analyzed/python_hindi_{model} - python_hindi_{model}.csv

Conventions:
- Empty cell = "none" (no comment/literal present in the method).
- Labels lowercased. Rare label typos (e.g., 'v', 'english+spanish') are mapped to 'other'.

Outputs (written to data/rebuttal/classeval_results/):
- classeval_table9.csv       : long-format table (language, model, category, E, T, B, none, total)
- classeval_table9_wide.csv  : wide-format table matching the layout of paper Table 9
"""

import csv
import os

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
MANUAL_DIR = os.path.join(BASE, "data", "classeval_manual_analysis")
OUT_DIR = os.path.join(BASE, "data", "rebuttal", "classeval_results")
os.makedirs(OUT_DIR, exist_ok=True)

MODELS = ["gpt", "deepseek", "claude"]
LANGUAGES = ["chinese", "hindi", "spanish", "italian"]
LANG_SHORT = {"chinese": "C", "hindi": "H", "spanish": "S", "italian": "I"}

# File locator per language/model. Some files use non-standard names.
FILE_MAP = {
    ("chinese", "gpt"): ("Chinese_labeled", "python_chinese_gpt.csv", ","),
    ("chinese", "deepseek"): ("Chinese_labeled", "python_chinese_deepseek.csv", ","),
    ("chinese", "claude"): ("Chinese_labeled", "python_chinese_claude_fixed.csv", ","),
    ("italian", "gpt"): ("italian-manual-analysis", "python_italian_gpt.csv", ","),
    ("italian", "deepseek"): ("italian-manual-analysis", "python_italian_deepseek.csv", ","),
    ("italian", "claude"): ("italian-manual-analysis", "python_italian_claude.csv", ","),
    ("spanish", "gpt"): ("spanish-manual-analysis", "python_spanish_gpt.csv", ";"),
    ("spanish", "deepseek"): ("spanish-manual-analysis", "python_spanish_deepseek.csv", ","),
    ("spanish", "claude"): ("spanish-manual-analysis", "python_spanish_claude.csv", ","),
    ("hindi", "gpt"): ("hindi-manually-analyzed", "python_hindi_gpt - python_hindi_gpt.csv", ","),
    ("hindi", "deepseek"): ("hindi-manually-analyzed", "python_hindi_deepseek - python_hindi_deepseek.csv", ","),
    ("hindi", "claude"): ("hindi-manually-analyzed", "python_hindi_claude - python_hindi_claude.csv", ","),
}


def normalize_label(value, target_lang):
    """Map a raw label cell to one of: english, target, both, none, other."""
    if value is None:
        return "none"
    v = value.strip().lower()
    if v == "":
        return "none"
    if v == "english":
        return "english"
    if v == target_lang:
        return "target"
    if v == "both":
        return "both"
    if "english" in v and target_lang in v:
        return "both"
    return "other"


def count_labels(path, delimiter, target_lang):
    """Return dicts of counts for comments, identifiers, literals."""
    categories = {k: {"english": 0, "target": 0, "both": 0, "none": 0, "other": 0}
                  for k in ["comments", "identifiers", "literals"]}
    total = 0
    with open(path, newline="", encoding="utf-8") as f:
        reader = csv.DictReader(f, delimiter=delimiter)
        for row in reader:
            total += 1
            for col in categories:
                label = normalize_label(row.get(col), target_lang)
                categories[col][label] += 1
    return categories, total


def pct(n, total):
    return round(100.0 * n / total, 2) if total > 0 else 0.0


def main():
    # Long format output
    long_rows = []
    # Wide format output (like paper Table 9)
    wide_rows = {}  # key = (model, category), value = {lang: (E, T, B, total)}

    for lang in LANGUAGES:
        for model in MODELS:
            subdir, fname, delim = FILE_MAP[(lang, model)]
            path = os.path.join(MANUAL_DIR, subdir, fname)
            if not os.path.exists(path):
                print(f"MISSING: {path}")
                continue
            cats, total = count_labels(path, delim, lang)
            print(f"{lang:8s} {model:8s} total={total}")
            for cat in ["comments", "identifiers", "literals"]:
                c = cats[cat]
                long_rows.append({
                    "language": lang,
                    "model": model,
                    "category": cat,
                    "total_methods": total,
                    "english_count": c["english"],
                    "target_count": c["target"],
                    "both_count": c["both"],
                    "none_count": c["none"],
                    "other_count": c["other"],
                    "english_pct": pct(c["english"], total),
                    "target_pct": pct(c["target"], total),
                    "both_pct": pct(c["both"], total),
                    "none_pct": pct(c["none"], total),
                    "other_pct": pct(c["other"], total),
                })
                wide_rows.setdefault((model, cat), {})[lang] = (
                    c["english"], c["target"], c["both"], total
                )

    # Write long format
    long_path = os.path.join(OUT_DIR, "classeval_table9.csv")
    with open(long_path, "w", newline="") as f:
        writer = csv.DictWriter(f, fieldnames=list(long_rows[0].keys()))
        writer.writeheader()
        writer.writerows(long_rows)
    print(f"Wrote {long_path}")

    # Write wide format matching paper Table 9
    wide_path = os.path.join(OUT_DIR, "classeval_table9_wide.csv")
    with open(wide_path, "w", newline="") as f:
        writer = csv.writer(f)
        # Header rows
        header1 = ["model", "category"]
        header2 = ["", ""]
        for lang in LANGUAGES:
            s = LANG_SHORT[lang]
            header1 += [lang.capitalize(), "", ""]
            header2 += [f"E", s, "B"]
        writer.writerow(header1)
        writer.writerow(header2)
        # Data rows
        for cat in ["comments", "identifiers", "literals"]:
            for model in MODELS:
                row = [model, cat]
                for lang in LANGUAGES:
                    e, t, b, tot = wide_rows[(model, cat)][lang]
                    row += [pct(e, tot), pct(t, tot), pct(b, tot)]
                writer.writerow(row)
    print(f"Wrote {wide_path}")

    # Pretty-print summary to stdout
    print()
    print("=" * 80)
    print("ClassEval Table 9 equivalent — percentage of methods (out of 410)")
    print("=" * 80)
    for cat in ["comments", "literals"]:
        print(f"\n{cat.upper()}")
        header = f"{'Model':<10} |"
        for lang in LANGUAGES:
            s = LANG_SHORT[lang]
            header += f" {lang[:4].capitalize():>5} (E/{s}/B) |"
        print(header)
        print("-" * len(header))
        for model in MODELS:
            row = f"  {model:<8} |"
            for lang in LANGUAGES:
                e, t, b, tot = wide_rows[(model, cat)][lang]
                row += f" {pct(e,tot):4.1f}/{pct(t,tot):4.1f}/{pct(b,tot):4.1f} |"
            print(row)


if __name__ == "__main__":
    main()
