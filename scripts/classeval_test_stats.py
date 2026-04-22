"""
Statistical tests on ClassEval test-pass results (per-model).

Mirrors the saved output of scripts/multilingual-script.R ('tests' block):
- McNemar + Cohen's g paired (english vs each target language) for each model.

Cochran's Q is intentionally NOT run here: the paper's R script computes it
but does not save the result (it is only printed), and the consensus is to
report only McNemar + Cohen's g as the test-pass statistical evidence. Keeping
ClassEval aligned with CoderEval on this point.

Input:
  data/rebuttal/classeval_results/classeval_test_results.csv
    (from classeval_run_tests.py)

Output:
  data/rebuttal/classeval_results/classeval_test_mcnemar.csv
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
    """Exact binomial McNemar on discordant pairs (b,c).
    b = count where english=pass, target=fail
    c = count where english=fail, target=pass
    """
    from math import comb
    n = b + c
    if n == 0:
        return 1.0
    m = min(b, c)
    # two-sided probability via binomial(0.5)
    p = sum(comb(n, i) for i in range(0, m + 1)) / (2 ** n) * 2
    return min(p, 1.0)


def cohens_g(b, c):
    """Cohen's g for McNemar: p̂−0.5 where p̂ = max(b,c)/(b+c). Sign indicates direction."""
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

    # Group: model -> (iter, id) -> lang -> passed (0/1)
    groups = defaultdict(lambda: defaultdict(dict))
    for r in rows:
        groups[r["model"]][(r["iteration"], r["id"])][r["language"]] = int(bool(r["passed"]))

    mcn_rows = []
    pvals_mcn = []

    for model in MODELS:
        g = groups.get(model, {})
        if not g:
            continue
        complete = [d for d in g.values() if all(l in d for l in LANGUAGES)]
        if len(complete) < 5:
            continue

        for lang in NON_ENGLISH:
            eng = [d["english"] for d in complete]
            tgt = [d[lang] for d in complete]
            b = sum(1 for e, t in zip(eng, tgt) if e == 1 and t == 0)  # eng pass, tgt fail
            c = sum(1 for e, t in zip(eng, tgt) if e == 0 and t == 1)  # eng fail, tgt pass
            pm = mcnemar_exact(b, c)
            gval, mag = cohens_g(b, c)
            passedEng = round(100 * sum(eng) / len(eng), 2)
            passedLang = round(100 * sum(tgt) / len(tgt), 2)
            mcn_rows.append({
                "model": model, "language": lang,
                "n_pairs": len(complete),
                "passed_english_pct": passedEng,
                "passed_lang_pct": passedLang,
                "b_engPass_langFail": b,
                "c_engFail_langPass": c,
                "p_value": round(pm, 6),
                "cohens_g": gval, "magnitude": mag,
            })
            pvals_mcn.append(pm)

    adj_m = bh_adjust(pvals_mcn)
    for r, pa in zip(mcn_rows, adj_m):
        r["p_adj_BH"] = round(pa, 6)
        r["significant_0.05"] = pa < 0.05

    if mcn_rows:
        out = os.path.join(RES_DIR, "classeval_test_mcnemar.csv")
        with open(out, "w", newline="") as f:
            w = csv.DictWriter(f, fieldnames=list(mcn_rows[0].keys()))
            w.writeheader(); w.writerows(mcn_rows)
        print(f"Wrote {out}")

    # Pretty print
    print()
    print("=== McNemar (english vs each target, per model) ===")
    for r in mcn_rows:
        print(f"  {r['model']:8s}  {r['language']:8s}  eng={r['passed_english_pct']}%  tgt={r['passed_lang_pct']}%  "
              f"g={r['cohens_g']} ({r['magnitude']})  p={r['p_value']:.4f}  p(BH)={r['p_adj_BH']:.4f}  sig={r['significant_0.05']}")


if __name__ == "__main__":
    main()
