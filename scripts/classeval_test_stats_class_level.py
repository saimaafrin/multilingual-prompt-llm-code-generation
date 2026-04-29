"""
Class-level McNemar + Cohen's g for ClassEval (rebuttal).

Counterpart to scripts/classeval_test_stats.py, but the unit of analysis is the
**class-attempt** instead of the method-attempt.

Class pass criterion (strict, matches upstream ClassEval `class_success`):
    A class is counted as passed in iteration i (for a given language and model)
    iff every method in that class is `success` in iteration i, i.e., every
    method's test class produced 0 errors and 0 failures with at least one
    test executed.

Pairing: paired on (task_id, iteration) between english and each target
language. b = English passed, target failed; c = English failed, target passed.

Output:
    data/rebuttal/classeval_results/classeval_test_mcnemar_class_level.csv
"""

import csv
import os
from collections import defaultdict

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
RES_DIR = os.path.join(BASE, "data", "rebuttal", "classeval_results")
IN_PATH = os.path.join(RES_DIR, "classeval_test_results.csv")

LANGUAGES = ["english", "chinese", "hindi", "spanish", "italian"]
NON_ENGLISH = ["chinese", "hindi", "spanish", "italian"]
MODELS = ["gpt", "deepseek", "claude"]


def load():
    rows = list(csv.DictReader(open(IN_PATH)))
    for r in rows:
        r["passed"] = r["passed"] == "True"
        try:
            r["iteration"] = int(r["iteration"])
        except Exception:
            r["iteration"] = 0
    return rows


def class_pass_table(rows):
    """Return dict[(model, lang, task_id, iter)] -> bool (class passed iff every
    method in the class passed in that iteration)."""
    methods = defaultdict(list)
    for r in rows:
        key = (r["model"], r["language"], r["task_id"], r["iteration"])
        methods[key].append(r["passed"])
    return {k: all(v) for k, v in methods.items()}


def bh_adjust(pvals):
    n = len(pvals)
    if n == 0:
        return []
    order = sorted(range(n), key=lambda i: pvals[i])
    adj = [0.0] * n
    prev = 1.0
    for rank, i in enumerate(reversed(order), 1):
        k = n - rank + 1
        q = pvals[i] * n / k
        q = min(q, prev)
        prev = q
        adj[i] = min(q, 1.0)
    return adj


def mcnemar_exact(b, c):
    from math import comb
    n = b + c
    if n == 0:
        return 1.0
    m = min(b, c)
    p = sum(comb(n, i) for i in range(0, m + 1)) / (2 ** n) * 2
    return min(p, 1.0)


def cohens_g(b, c):
    if b + c == 0:
        return 0.0, "null"
    p = max(b, c) / (b + c)
    g = p - 0.5
    if g < 0.05: mag = "null"
    elif g < 0.15: mag = "small"
    elif g < 0.25: mag = "medium"
    else: mag = "large"
    return round(g, 4), mag


def main():
    rows = load()
    cls = class_pass_table(rows)

    out_rows = []
    pvals = []

    for model in MODELS:
        # Collect all (task_id, iter) pairs that have *all* 5 languages
        keys_by_lang = defaultdict(set)
        for (m, lang, task, it), passed in cls.items():
            if m == model:
                keys_by_lang[lang].add((task, it))
        common = set.intersection(*[keys_by_lang[l] for l in LANGUAGES]) if all(l in keys_by_lang for l in LANGUAGES) else set()
        if not common:
            continue
        common = sorted(common)

        for lang in NON_ENGLISH:
            eng = [int(cls[(model, "english", t, i)]) for (t, i) in common]
            tgt = [int(cls[(model, lang, t, i)]) for (t, i) in common]
            b = sum(1 for e, x in zip(eng, tgt) if e == 1 and x == 0)
            c = sum(1 for e, x in zip(eng, tgt) if e == 0 and x == 1)
            pm = mcnemar_exact(b, c)
            gval, mag = cohens_g(b, c)
            passedEng = round(100 * sum(eng) / len(eng), 2)
            passedLang = round(100 * sum(tgt) / len(tgt), 2)
            out_rows.append({
                "model": model, "language": lang,
                "n_class_pairs": len(common),
                "passed_english_pct": passedEng,
                "passed_lang_pct": passedLang,
                "b_engPass_langFail": b,
                "c_engFail_langPass": c,
                "p_value": round(pm, 6),
                "cohens_g": gval, "magnitude": mag,
            })
            pvals.append(pm)

    adj = bh_adjust(pvals)
    for r, pa in zip(out_rows, adj):
        r["p_adj_BH"] = round(pa, 6)
        r["significant_0.05"] = pa < 0.05

    if out_rows:
        out_path = os.path.join(RES_DIR, "classeval_test_mcnemar_class_level.csv")
        with open(out_path, "w", newline="") as f:
            w = csv.DictWriter(f, fieldnames=list(out_rows[0].keys()))
            w.writeheader(); w.writerows(out_rows)
        print(f"Wrote {out_path}")

    print()
    print("=== Class-level McNemar (english vs each target, per model) ===")
    for r in out_rows:
        print(f"  {r['model']:8s}  {r['language']:8s}  n_pairs={r['n_class_pairs']:>5}  "
              f"eng={r['passed_english_pct']}%  tgt={r['passed_lang_pct']}%  "
              f"g={r['cohens_g']} ({r['magnitude']})  "
              f"p={r['p_value']:.4f}  p(BH)={r['p_adj_BH']:.4f}  sig={r['significant_0.05']}")


if __name__ == "__main__":
    main()
