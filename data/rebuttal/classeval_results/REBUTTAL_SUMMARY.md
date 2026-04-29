# ClassEval Rebuttal — Summary of Results

This file summarizes the ClassEval replication of the CoderEval study used to address reviewer comment 1.1. All numbers are derived directly from the CSV artifacts in this directory; rerun the scripts in `scripts/` to reproduce.

## Data coverage

- **Benchmark**: ClassEval (100 classes, 410 methods)
- **Natural languages**: English (baseline), Chinese, Hindi, Spanish, Italian
- **Models**: GPT, DeepSeek, Claude
- **Iterations**: Claude — 10 iterations per language (4100 methods per language). GPT and DeepSeek — 1 iteration per language (from the manual-analysis sample).
- **Programming language**: Python only — ClassEval has no Java split upstream.
- **Static-analysis tools**: Lizard / Flake8 / Pylint. PMD is Java-only; SonarCloud was dropped because on CoderEval it produced the same language orderings as Pylint at comparable effect sizes.

## Test pass rates

Percentage of generated methods that pass ClassEval's unit tests. Each generated method was spliced into the ground-truth class and evaluated against the method-specific test class (e.g., `AccessGatewayFilterTestFilter`).

| Model | English | Chinese | Hindi | Spanish | Italian |
| --- | --- | --- | --- | --- | --- |
| gpt | 73.17% (300/410) | 73.17% (300/410) | 73.17% (300/410) | 72.44% (297/410) | 71.71% (294/410) |
| deepseek | 76.83% (315/410) | 77.56% (318/410) | 75.37% (309/410) | 74.39% (305/410) | 75.12% (308/410) |
| claude | 55.12% (2260/4100) | 53.12% (2178/4100) | 53.12% (2178/4100) | 51.34% (2105/4100) | 52.46% (2151/4100) |

Per-iteration detail for Claude (10 iterations per language) is in `classeval_pass_rates_by_iter.csv`.

### Upstream ClassEval pass@n (faithful port of `cal_metrics_pass_at_k`)

Per-sample classification (`get_test_answer`): a sample is `success` iff all unit tests passed; `partial_success` iff some passed and none crashed; `error` iff the run crashed; `fail` iff every test failed by assertion. `pass@n` is computed with the unbiased Chen et al. estimator over the `k` samples we have per task (k = number of iterations: 10 for Claude, 1 for GPT/DeepSeek, so the greedy GPT/DeepSeek rows only have pass@1).

#### `fun_success`

| Model | Lang | k | pass@1 | pass@3 | pass@5 | pass@10 |
| --- | --- | --- | --- | --- | --- | --- |
| gpt | english | 1 | 0.7317 | — | — | — |
| gpt | chinese | 1 | 0.7317 | — | — | — |
| gpt | hindi | 1 | 0.7317 | — | — | — |
| gpt | spanish | 1 | 0.7244 | — | — | — |
| gpt | italian | 1 | 0.7171 | — | — | — |
| deepseek | english | 1 | 0.7683 | — | — | — |
| deepseek | chinese | 1 | 0.7756 | — | — | — |
| deepseek | hindi | 1 | 0.7537 | — | — | — |
| deepseek | spanish | 1 | 0.7439 | — | — | — |
| deepseek | italian | 1 | 0.7512 | — | — | — |
| claude | english | 10 | 0.5512 | 0.559 | 0.5626 | 0.5659 |
| claude | chinese | 10 | 0.5312 | 0.5518 | 0.5583 | 0.5634 |
| claude | hindi | 10 | 0.5312 | 0.5376 | 0.5407 | 0.5463 |
| claude | spanish | 10 | 0.5134 | 0.5268 | 0.5297 | 0.5317 |
| claude | italian | 10 | 0.5246 | 0.538 | 0.5436 | 0.5488 |

#### `fun_partial_success`

| Model | Lang | k | pass@1 | pass@3 | pass@5 | pass@10 |
| --- | --- | --- | --- | --- | --- | --- |
| gpt | english | 1 | 0.8927 | — | — | — |
| gpt | chinese | 1 | 0.9 | — | — | — |
| gpt | hindi | 1 | 0.8878 | — | — | — |
| gpt | spanish | 1 | 0.8854 | — | — | — |
| gpt | italian | 1 | 0.8878 | — | — | — |
| deepseek | english | 1 | 0.9024 | — | — | — |
| deepseek | chinese | 1 | 0.9024 | — | — | — |
| deepseek | hindi | 1 | 0.8976 | — | — | — |
| deepseek | spanish | 1 | 0.9 | — | — | — |
| deepseek | italian | 1 | 0.8976 | — | — | — |
| claude | english | 10 | 0.7863 | 0.7969 | 0.8003 | 0.8024 |
| claude | chinese | 10 | 0.7598 | 0.7806 | 0.7866 | 0.7927 |
| claude | hindi | 10 | 0.7654 | 0.7696 | 0.7712 | 0.7732 |
| claude | spanish | 10 | 0.7417 | 0.7526 | 0.7563 | 0.761 |
| claude | italian | 10 | 0.7451 | 0.7542 | 0.7568 | 0.7585 |

#### `class_success`

| Model | Lang | k | pass@1 | pass@3 | pass@5 | pass@10 |
| --- | --- | --- | --- | --- | --- | --- |
| gpt | english | 1 | 0.37 | — | — | — |
| gpt | chinese | 1 | 0.36 | — | — | — |
| gpt | hindi | 1 | 0.38 | — | — | — |
| gpt | spanish | 1 | 0.34 | — | — | — |
| gpt | italian | 1 | 0.33 | — | — | — |
| deepseek | english | 1 | 0.41 | — | — | — |
| deepseek | chinese | 1 | 0.45 | — | — | — |
| deepseek | hindi | 1 | 0.39 | — | — | — |
| deepseek | spanish | 1 | 0.36 | — | — | — |
| deepseek | italian | 1 | 0.38 | — | — | — |
| claude | english | 10 | 0.128 | 0.13 | 0.13 | 0.13 |
| claude | chinese | 10 | 0.113 | 0.1224 | 0.1269 | 0.13 |
| claude | hindi | 10 | 0.102 | 0.1053 | 0.1078 | 0.11 |
| claude | spanish | 10 | 0.103 | 0.1172 | 0.1197 | 0.12 |
| claude | italian | 10 | 0.083 | 0.0883 | 0.0928 | 0.1 |

#### `class_partial_success`

| Model | Lang | k | pass@1 | pass@3 | pass@5 | pass@10 |
| --- | --- | --- | --- | --- | --- | --- |
| gpt | english | 1 | 0.75 | — | — | — |
| gpt | chinese | 1 | 0.8 | — | — | — |
| gpt | hindi | 1 | 0.77 | — | — | — |
| gpt | spanish | 1 | 0.74 | — | — | — |
| gpt | italian | 1 | 0.76 | — | — | — |
| deepseek | english | 1 | 0.79 | — | — | — |
| deepseek | chinese | 1 | 0.79 | — | — | — |
| deepseek | hindi | 1 | 0.77 | — | — | — |
| deepseek | spanish | 1 | 0.78 | — | — | — |
| deepseek | italian | 1 | 0.78 | — | — | — |
| claude | english | 10 | 0.519 | 0.5321 | 0.5369 | 0.54 |
| claude | chinese | 10 | 0.477 | 0.5085 | 0.5205 | 0.54 |
| claude | hindi | 10 | 0.49 | 0.4953 | 0.4978 | 0.5 |
| claude | spanish | 10 | 0.454 | 0.4727 | 0.4792 | 0.49 |
| claude | italian | 10 | 0.467 | 0.4763 | 0.4791 | 0.48 |


### Class-level pass rate (strict, from `classeval_class_level_pass_rates.csv`)

Fraction of class-attempts where every method in the class passed in the same iteration. Equivalent to upstream `class_success` pass@1 evaluated as a simple mean (no Chen et al. correction).

| Model | English | Chinese | Hindi | Spanish | Italian |
| --- | --- | --- | --- | --- | --- |
| gpt | 37.0% (37/100) | 36.0% (36/100) | 38.0% (38/100) | 34.0% (34/100) | 33.0% (33/100) |
| deepseek | 41.0% (41/100) | 45.0% (45/100) | 39.0% (39/100) | 36.0% (36/100) | 38.0% (38/100) |
| claude | 12.8% (128/1000) | 11.3% (113/1000) | 10.2% (102/1000) | 10.3% (103/1000) | 8.3% (83/1000) |

### McNemar — English vs each target language (per model, paired on (iteration, method))

Matches the `python-{model}-test.csv` output produced by the paper's R script for CoderEval. Rows paired on (task, iteration); `b` counts cases where English passed and the target language failed; `c` counts the reverse.

| Model | Target | n pairs | passed Eng % | passed Lang % | b (E+, T−) | c (E−, T+) | p (BH) | Cohen's g | magnitude | sig. |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| gpt | chinese | 410 | 73.17 | 73.17 | 7 | 7 | 1.0 | 0.0 | null | False |
| gpt | hindi | 410 | 73.17 | 73.17 | 10 | 10 | 1.0 | 0.0 | null | False |
| gpt | spanish | 410 | 73.17 | 72.44 | 13 | 10 | 0.813167 | 0.0652 | small | False |
| gpt | italian | 410 | 73.17 | 71.71 | 14 | 8 | 0.429418 | 0.1364 | small | False |
| deepseek | chinese | 410 | 76.83 | 77.56 | 9 | 12 | 0.813167 | 0.0714 | small | False |
| deepseek | hindi | 410 | 76.83 | 75.37 | 13 | 7 | 0.429418 | 0.15 | medium | False |
| deepseek | spanish | 410 | 76.83 | 74.39 | 16 | 6 | 0.125949 | 0.2273 | medium | False |
| deepseek | italian | 410 | 76.83 | 75.12 | 16 | 9 | 0.429418 | 0.14 | small | False |
| claude | chinese | 4100 | 55.12 | 53.12 | 191 | 109 | 1e-05 | 0.1367 | small | True |
| claude | hindi | 4100 | 55.12 | 53.12 | 200 | 118 | 1.5e-05 | 0.1289 | small | True |
| claude | spanish | 4100 | 55.12 | 51.34 | 283 | 128 | 0.0 | 0.1886 | medium | True |
| claude | italian | 4100 | 55.12 | 52.46 | 260 | 151 | 1e-06 | 0.1326 | small | True |

### McNemar — class-level (paired on (task_id, iteration); class passes iff every method passes)

Use these effect sizes alongside the class-level pass-rate table above. `n_class_pairs` = 100 for greedy GPT/DeepSeek (1 iteration × 100 classes) and 1000 for Claude (10 iterations × 100 classes).

| Model | Target | n class pairs | passed Eng % | passed Lang % | b (E+, T−) | c (E−, T+) | p (BH) | Cohen's g | magnitude | sig. |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| gpt | chinese | 100 | 37.0 | 36.0 | 5 | 4 | 1.0 | 0.0556 | small | False |
| gpt | hindi | 100 | 37.0 | 38.0 | 4 | 5 | 1.0 | 0.0556 | small | False |
| gpt | spanish | 100 | 37.0 | 34.0 | 7 | 4 | 0.77474 | 0.1364 | small | False |
| gpt | italian | 100 | 37.0 | 33.0 | 7 | 3 | 0.6875 | 0.2 | medium | False |
| deepseek | chinese | 100 | 41.0 | 45.0 | 5 | 9 | 0.726772 | 0.1429 | small | False |
| deepseek | hindi | 100 | 41.0 | 39.0 | 7 | 5 | 0.929297 | 0.0833 | small | False |
| deepseek | spanish | 100 | 41.0 | 36.0 | 9 | 4 | 0.64043 | 0.1923 | medium | False |
| deepseek | italian | 100 | 41.0 | 38.0 | 8 | 5 | 0.77474 | 0.1154 | small | False |
| claude | chinese | 1000 | 12.8 | 11.3 | 31 | 16 | 0.119958 | 0.1596 | medium | False |
| claude | hindi | 1000 | 12.8 | 10.2 | 39 | 13 | 0.002457 | 0.25 | large | True |
| claude | spanish | 1000 | 12.8 | 10.3 | 45 | 20 | 0.010506 | 0.1923 | medium | True |
| claude | italian | 1000 | 12.8 | 8.3 | 47 | 2 | 0.0 | 0.4592 | large | True |

## Qualitative analysis (Table 9 equivalent)

Percentage of methods (out of 410) whose comments / literals were written in the indicated language. E = English, target = Chinese/Hindi/Spanish/Italian, B = both.

### Comments

| Model | Chinese E | Chinese C | Chinese B | Hindi E | Hindi H | Hindi B | Spanish E | Spanish S | Spanish B | Italian E | Italian I | Italian B |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| gpt | 0.2 | 0.0 | 0.0 | 0.0 | 0.0 | 0.0 | 0.0 | 0.0 | 0.0 | 0.0 | 0.0 | 0.0 |
| deepseek | 0.2 | 0.2 | 0.0 | 0.0 | 0.0 | 0.0 | 0.2 | 0.0 | 0.0 | 0.0 | 0.0 | 0.0 |
| claude | 19.0 | 25.6 | 0.7 | 40.5 | 3.4 | 0.0 | 23.7 | 16.8 | 0.2 | 0.0 | 0.0 | 0.0 |

### Literals

| Model | Chinese E | Chinese C | Chinese B | Hindi E | Hindi H | Hindi B | Spanish E | Spanish S | Spanish B | Italian E | Italian I | Italian B |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| gpt | 2.2 | 0.2 | 0.0 | 5.6 | 1.0 | 0.0 | 30.2 | 2.7 | 0.2 | 37.1 | 2.2 | 0.0 |
| deepseek | 5.4 | 0.5 | 0.0 | 8.5 | 1.2 | 0.0 | 36.1 | 2.9 | 0.2 | 32.7 | 2.9 | 0.0 |
| claude | 4.2 | 1.5 | 0.0 | 6.1 | 1.9 | 0.0 | 35.4 | 4.2 | 0.0 | 34.9 | 5.6 | 0.0 |

## Quantitative analysis (code metrics)

Mean metric per (language, model). For Claude values are averaged across the 10 iterations; for GPT / DeepSeek values come from the single iteration included in the qualitative-analysis sample.

| Language | Model | n methods | mean nloc | mean ccn | mean tokens | mean length | mean top-nest | mean flake8 | mean pylint |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| chinese | claude | 410 | 9.67 | 4.03 | 69.69 | 23.08 | 1.07 | 4.56 | 9.88 |
| chinese | deepseek | 410 | 7.84 | 3.3 | 58.8 | 16.95 | 1.0 | 2.55 | 7.76 |
| chinese | gpt | 410 | 5.98 | 2.59 | 48.69 | 14.88 | 1.0 | 2.39 | 7.3 |
| english | claude | 410 | 8.89 | 3.66 | 64.14 | 21.76 | 1.03 | 5.05 | 9.73 |
| english | deepseek | 410 | 7.89 | 3.29 | 58.93 | 17.0 | 1.01 | 3.4 | 8.1 |
| english | gpt | 410 | 6.01 | 2.6 | 48.6 | 14.92 | 1.0 | 3.2 | 7.69 |
| hindi | claude | 410 | 9.53 | 3.95 | 69.3 | 23.1 | 1.04 | 5.58 | 10.32 |
| hindi | deepseek | 410 | 7.84 | 3.25 | 58.67 | 17.11 | 1.01 | 3.53 | 8.39 |
| hindi | gpt | 410 | 5.98 | 2.59 | 48.12 | 15.1 | 1.0 | 3.28 | 7.81 |
| italian | claude | 410 | 9.1 | 3.73 | 65.22 | 22.29 | 1.03 | 5.34 | 9.93 |
| italian | deepseek | 410 | 8.03 | 3.37 | 60.47 | 17.11 | 1.0 | 3.66 | 8.37 |
| italian | gpt | 410 | 6.0 | 2.63 | 48.73 | 14.93 | 1.0 | 3.37 | 7.77 |
| spanish | claude | 410 | 9.43 | 3.84 | 67.17 | 22.67 | 1.03 | 5.51 | 10.14 |
| spanish | deepseek | 410 | 7.95 | 3.28 | 59.47 | 17.01 | 1.0 | 3.7 | 8.37 |
| spanish | gpt | 410 | 6.0 | 2.62 | 48.86 | 14.9 | 1.0 | 3.33 | 7.79 |

## Statistical tests (Claude, 10 iterations)

### Friedman tests across the 5 languages (per metric, BH-adjusted p)

| Metric | n paired rows | p-value | p (BH) | significant (α=0.05) |
| --- | --- | --- | --- | --- |
| nloc | 4100 | 0.0 | 0.0 | True |
| ccn | 4100 | 0.0 | 0.0 | True |
| token_count | 4100 | 0.0 | 0.0 | True |
| length | 4100 | 0.0 | 0.0 | True |
| top_nesting_level | 4100 | 0.0 | 0.0 | True |
| flake8 | 4100 | 0.0 | 0.0 | True |
| pylint | 4100 | 0.0 | 0.0 | True |

### Wilcoxon: English vs target language (per metric, BH-adjusted p + Cliff's delta)

| Metric | Target | n pairs | p-value | p (BH) | sig. | Cliff δ | magnitude |
| --- | --- | --- | --- | --- | --- | --- | --- |
| nloc | chinese | 4100 | 0.0 | 0.0 | True | 0.0463 | negligible |
| nloc | hindi | 4100 | 0.0 | 0.0 | True | 0.0375 | negligible |
| nloc | spanish | 4100 | 0.0 | 0.0 | True | 0.0251 | negligible |
| nloc | italian | 4100 | 0.000427 | 0.000498 | True | 0.0065 | negligible |
| ccn | chinese | 4100 | 0.0 | 0.0 | True | 0.0355 | negligible |
| ccn | hindi | 4100 | 0.0 | 0.0 | True | 0.0353 | negligible |
| ccn | spanish | 4100 | 0.0 | 0.0 | True | 0.0133 | negligible |
| ccn | italian | 4100 | 0.844372 | 0.844372 | False | -0.0022 | negligible |
| token_count | chinese | 4100 | 0.0 | 0.0 | True | 0.0348 | negligible |
| token_count | hindi | 4100 | 0.0 | 0.0 | True | 0.032 | negligible |
| token_count | spanish | 4100 | 0.0 | 0.0 | True | 0.0139 | negligible |
| token_count | italian | 4100 | 0.150101 | 0.168113 | False | -0.0031 | negligible |
| length | chinese | 4100 | 0.0 | 0.0 | True | 0.0432 | negligible |
| length | hindi | 4100 | 0.0 | 0.0 | True | 0.0522 | negligible |
| length | spanish | 4100 | 0.0 | 0.0 | True | 0.0313 | negligible |
| length | italian | 4100 | 0.0 | 0.0 | True | 0.0121 | negligible |
| top_nesting_level | chinese | 4100 | 0.0 | 0.0 | True | 0.0341 | negligible |
| top_nesting_level | hindi | 4100 | 0.000214 | 0.00026 | True | 0.0054 | negligible |
| top_nesting_level | spanish | 4100 | 0.54796 | 0.568255 | False | -0.0003 | negligible |
| top_nesting_level | italian | 4100 | 0.238185 | 0.256507 | False | 0.0022 | negligible |
| flake8 | chinese | 4100 | 0.0 | 0.0 | True | -0.1056 | negligible |
| flake8 | hindi | 4100 | 0.0 | 0.0 | True | 0.0654 | negligible |
| flake8 | spanish | 4100 | 0.0 | 0.0 | True | 0.0709 | negligible |
| flake8 | italian | 4100 | 0.0 | 0.0 | True | 0.0456 | negligible |
| pylint | chinese | 4100 | 1.6e-05 | 2.1e-05 | True | -0.0112 | negligible |
| pylint | hindi | 4100 | 0.0 | 0.0 | True | 0.0658 | negligible |
| pylint | spanish | 4100 | 0.0 | 0.0 | True | 0.0419 | negligible |
| pylint | italian | 4100 | 0.0 | 0.0 | True | 0.0293 | negligible |

## Files produced in this directory

- `classeval_table9.csv` / `classeval_table9_wide.csv` — per-category, per-model, per-language counts and percentages.
- `classeval_qualitative_summary.csv` — tidy version of Table 9.
- `classeval_metrics_per_method.csv` — one row per (method, iteration, language, model) with Lizard / Flake8 / Pylint metrics.
- `classeval_metrics_summary.csv` — mean metric per (language, model, iteration).
- `classeval_python_{model}_report.csv` — wide per-method report mirroring `data/4_quantitative_analysis/python_{model}_report.csv` used by the R script.
- `classeval_descriptive.csv` — mean + std per (language, model).
- `classeval_friedman_claude.csv` / `classeval_wilcoxon_claude.csv` — statistical tests on Claude's 10 iterations.
- `classeval_test_results.csv` — raw per-method test outcomes (errors/failures/testsRun/passed/reason).
- `classeval_pass_rates.csv` / `classeval_pass_rates_by_iter.csv` — aggregated pass rates.
- `classeval_failure_breakdown.csv` — counts of each failure reason per (language, model).
- `classeval_test_mcnemar.csv` — method-level McNemar + Cohen's g on (English vs target) pass/fail pairs (matches the `python-{model}-test.csv` file produced by the R script for CoderEval).
- `classeval_test_mcnemar_class_level.csv` — class-level McNemar + Cohen's g (unit = class-attempt; pair on (task_id, iteration)).
- `classeval_pass_at_k_upstream.csv` / `classeval_pass_at_k_upstream_summary.txt` — upstream ClassEval `cal_metrics_pass_at_k` faithfully ported to Python (`fun_success`, `fun_partial_success`, `class_success`, `class_partial_success` for pass@n where n ≤ k).
- `classeval_class_level_pass_rates.csv` / `classeval_class_level_pass_rates_by_iter.csv` — simple class-level pass aggregation (every method in a class must pass in the same iteration).

## Caveats

- **Programming-language scope**: ClassEval is Python-only upstream, so this extension replicates the CoderEval study only for Python. No equivalent Java class-level benchmark is available.
- **Static-analysis scope**: PMD is Java-only and was therefore not applicable. SonarCloud was also skipped: in the CoderEval results, Pylint and SonarCloud produced consistent warning-count signals (same across-language orderings and comparable effect sizes), so running SonarCloud on ClassEval would have added no new information at the cost of the GitHub-Actions pipeline overhead. We therefore report only Lizard (size/complexity), Flake8 (style), and Pylint (warnings).
- **Test-pass rates**: computed using the upstream `fudan-selab/ClassEval` benchmark data. Each generated method was spliced into the ground-truth class (keeping all other methods correct) and only the method-specific test class was run. A method is counted as 'passed' iff its test class reports zero errors and zero failures with at least one test executed. Generations that could not be spliced (mostly Claude outputs that omit the method signature) and those that timed out are counted as failures. Full per-attempt outcomes are in `classeval_test_results.csv`.
- **Per-model iteration counts**: Claude has 10 iterations per language (matching the CoderEval protocol). GPT and DeepSeek have a single iteration per language (the one used for the manual qualitative labeling). Cross-language statistical tests are therefore reported for Claude only; GPT and DeepSeek are summarised descriptively.
