"""
Extract compilation rates and test pass rates from the test result JSONL files
in data/3_tests/results/{model}/{proglang}_{language}_{model}.jsonl_out.jsonl

For Java: distinguishes compile errors vs runtime errors vs pass
For Python: only has is_pass (no separate compile step)

Output: CSV tables printed to stdout and saved to data/4_quantitative_analysis/
"""

import json
import os

BASE = os.path.join(os.path.dirname(os.path.dirname(os.path.abspath(__file__))), "data")
RESULTS_DIR = os.path.join(BASE, "3_tests", "results")
OUT_DIR = os.path.join(BASE, "4_quantitative_analysis")

MODELS = ["gpt", "deepseek", "claude"]
LANGUAGES = ["english", "chinese", "hindi", "spanish", "italian"]
PROG_LANGS = ["java", "python"]


def parse_java_results(filepath):
    """Returns (total_iterations, compiled, passed) counts."""
    total = 0
    compiled = 0
    passed = 0
    with open(filepath) as f:
        for line in f:
            obj = json.loads(line)
            for r in obj["generate_results"]:
                total += 1
                err = r.get("errormessage", "")
                if err != "compile error":
                    compiled += 1
                if r.get("is_pass", False):
                    passed += 1
    return total, compiled, passed


def parse_python_results(filepath):
    """Returns (total_iterations, passed) counts. Python has no separate compile step."""
    total = 0
    passed = 0
    with open(filepath) as f:
        for line in f:
            obj = json.loads(line)
            for r in obj["generate_results"]:
                total += 1
                if r.get("is_pass", False):
                    passed += 1
    return total, passed


def main():
    # ---- Java: compilation rate + pass rate ----
    print("=" * 80)
    print("JAVA - Compilation Rate (%) and Test Pass Rate (%)")
    print("=" * 80)

    header = f"{'Model':<10}"
    for lang in LANGUAGES:
        header += f" | {lang:>20}"
    print(header)
    print("-" * len(header))

    java_rows = []
    for model in MODELS:
        row_compile = f"{'  ' + model:<10}"
        row_pass = f"{'  ' + model:<10}"
        compile_vals = {}
        pass_vals = {}
        for lang in LANGUAGES:
            fname = f"java_{lang}_{model}.jsonl_out.jsonl"
            fpath = os.path.join(RESULTS_DIR, model, fname)
            if not os.path.exists(fpath):
                row_compile += f" | {'N/A':>20}"
                row_pass += f" | {'N/A':>20}"
                continue
            total, compiled, passed = parse_java_results(fpath)
            comp_rate = (compiled / total * 100) if total > 0 else 0
            pass_rate = (passed / total * 100) if total > 0 else 0
            compile_vals[lang] = (compiled, total, comp_rate)
            pass_vals[lang] = (passed, total, pass_rate)
            row_compile += f" | {comp_rate:>6.1f}% ({compiled}/{total})"
            row_pass += f" | {pass_rate:>6.1f}% ({passed}/{total})"

        print(f"  Compile: ")
        print(row_compile)
        print(f"  Pass:    ")
        print(row_pass)
        print()
        java_rows.append((model, compile_vals, pass_vals))

    # ---- Python: pass rate ----
    print("=" * 80)
    print("PYTHON - Test Pass Rate (%)")
    print("=" * 80)

    print(header)
    print("-" * len(header))

    python_rows = []
    for model in MODELS:
        row_pass = f"  {model:<10}"
        pass_vals = {}
        for lang in LANGUAGES:
            fname = f"python_{lang}_{model}.jsonl_out.jsonl"
            fpath = os.path.join(RESULTS_DIR, model, fname)
            if not os.path.exists(fpath):
                row_pass += f" | {'N/A':>20}"
                continue
            total, passed = parse_python_results(fpath)
            pass_rate = (passed / total * 100) if total > 0 else 0
            pass_vals[lang] = (passed, total, pass_rate)
            row_pass += f" | {pass_rate:>6.1f}% ({passed}/{total})"

        print(row_pass)
        python_rows.append((model, pass_vals))

    print()

    # ---- Save as CSV ----
    # Java compilation
    csv_path = os.path.join(OUT_DIR, "java_compilation_rates.csv")
    with open(csv_path, "w") as f:
        f.write("model,language,compiled,total,compilation_rate\n")
        for model, compile_vals, _ in java_rows:
            for lang in LANGUAGES:
                if lang in compile_vals:
                    compiled, total, rate = compile_vals[lang]
                    f.write(f"{model},{lang},{compiled},{total},{rate:.2f}\n")
    print(f"Saved: {csv_path}")

    # Java pass rates
    csv_path = os.path.join(OUT_DIR, "java_pass_rates.csv")
    with open(csv_path, "w") as f:
        f.write("model,language,passed,total,pass_rate\n")
        for model, _, pass_vals in java_rows:
            for lang in LANGUAGES:
                if lang in pass_vals:
                    passed, total, rate = pass_vals[lang]
                    f.write(f"{model},{lang},{passed},{total},{rate:.2f}\n")
    print(f"Saved: {csv_path}")

    # Python pass rates
    csv_path = os.path.join(OUT_DIR, "python_pass_rates.csv")
    with open(csv_path, "w") as f:
        f.write("model,language,passed,total,pass_rate\n")
        for model, pass_vals in python_rows:
            for lang in LANGUAGES:
                if lang in pass_vals:
                    passed, total, rate = pass_vals[lang]
                    f.write(f"{model},{lang},{passed},{total},{rate:.2f}\n")
    print(f"Saved: {csv_path}")


if __name__ == "__main__":
    main()
