"""
Pylint analysis wrapper for ClassEval (rebuttal).

Differences from scripts/pylint_analysis.py:
- Does not raise on a non-zero pylint exit status (pylint returns non-zero
  whenever it emits warnings, which is normal).
- Invokes pylint with every *.py file passed explicitly as separate arguments,
  instead of passing the directory. When pylint receives an absolute directory
  path it treats it as a Python package and fails with a parse error about a
  missing __init__.py. The explicit-file form avoids that while still producing
  one aggregated JSON output for all files.

Output format matches pylint_analysis.py: pylint_report.csv with
(module, error_ids, error_messages, count).
"""

import csv as _csv
import json
import os
import subprocess
from collections import defaultdict


def pylint_analysis(input_path, output_path):
    os.makedirs(output_path, exist_ok=True)
    input_path = os.path.abspath(input_path)
    print(f"Running pylint analysis on {input_path}...")

    if os.path.isdir(input_path):
        py_files = sorted(
            os.path.join(input_path, f) for f in os.listdir(input_path) if f.endswith(".py")
        )
    else:
        py_files = [input_path]

    if not py_files:
        print("No .py files found.")
        return

    json_out_path = os.path.join(output_path, "pylint_output.json")
    try:
        proc = subprocess.run(
            ["pylint", "--output-format=json", *py_files],
            capture_output=True, text=True, timeout=900,
        )
        data = json.loads(proc.stdout) if proc.stdout.strip() else []
    except Exception as e:
        print(f"Error running Pylint: {e}")
        return

    with open(json_out_path, "w") as f:
        json.dump(data, f)

    if not data:
        print("No pylint issues found.")
        return

    # Aggregate by module
    by_module = defaultdict(list)
    for it in data:
        module = it.get("module", "")
        by_module[module].append((it.get("symbol", ""), it.get("message", "")))

    csv_output_path = os.path.join(output_path, "pylint_report.csv")
    with open(csv_output_path, "w", newline="") as f:
        writer = _csv.writer(f)
        writer.writerow(["module", "error_ids", "error_messages", "count"])
        for module in sorted(by_module):
            pairs = by_module[module]
            writer.writerow([
                module,
                ", ".join(p[0] for p in pairs),
                " | ".join(p[1] for p in pairs),
                len(pairs),
            ])
    print(f"Pylint analysis complete. Report saved as {csv_output_path}.")
