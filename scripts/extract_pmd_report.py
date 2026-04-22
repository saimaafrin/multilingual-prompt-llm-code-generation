import json
import os
import zipfile
import pandas as pd
from collections import defaultdict

def extract_pmd(report_file, report_path):
    """
    Extracts and processes PMD analysis results from a SARIF report and saves them to a CSV file.

    Parameters:
    - report_file (str): Path to the PMD SARIF report file.
    - report_path (str): Directory where the output CSV will be saved.

    Outputs:
    - A CSV file named 'pmd-report.csv' containing the extracted PMD findings.

    """
    with open(report_file, 'r') as file:
        sarif_data = json.load(file)

    # Dictionary to store information by file
    file_data = defaultdict(lambda: {'rules': [], 'messages': [], 'count': 0})

    for run in sarif_data.get('runs', []):
        # Create a quick lookup dictionary for rules
        rule_lookup = {rule['id']: rule for rule in run['tool']['driver']['rules']}

        for file_result in run.get('results', []):
            locations = file_result.get('locations', [])
            if not locations:
                continue  # Skip if no valid location

            artifact = locations[0].get('physicalLocation', {})
            file_name = artifact.get('artifactLocation', {}).get('uri', 'UnknownFile')

            # Match rule and message
            rule_id = file_result.get('ruleId')
            rule = rule_lookup.get(rule_id, {})
            rule_description = rule.get('fullDescription', {}).get('text', 'No description')
            message = file_result.get('message', {}).get('text', 'No message')

            # Collect information
            file_data[file_name]['rules'].append(f"{rule_id}: {rule_description}")
            file_data[file_name]['messages'].append(message)
            file_data[file_name]['count'] += 1

    # Create a pandas DataFrame from the collected data
    rows = [
        {
            'fileName': file_name,
            'rules': "; ".join(data['rules']),
            'message': "; ".join(data['messages']),
            'count': data['count']
        }
        for file_name, data in file_data.items()
    ]

    # Save DataFrame to CSV
    df = pd.DataFrame(rows)
    csv_file = os.path.join(report_path, "pmd-report.csv")
    df.to_csv(csv_file, index=False)
    print(f"CSV report generated successfully: {csv_file}")

def main():
    """
    Main function to process PMD reports for multiple languages and iterations.

    - Extracts PMD report ZIP files.
    - Parses and converts SARIF reports to CSV format.

    """
    # Ensure languages, prog_lang, and model are defined
    languages = ['italian', 'hindi', 'chinese', 'english', 'spanish']
    prog_lang = "java"
    models = ["deepseek", 'gpt', 'claude']
    iteration_number = 10

    for model in models:
        for language in languages:
            for iteration in range(iteration_number):
                zip_file = f"./Data/generation/{prog_lang}_{language}_{model}/iter_{iteration}/report/pmd-report.zip"
                report_path = f"./Data/generation/{prog_lang}_{language}_{model}/iter_{iteration}/report"

                # Extract ZIP contents
                try:
                    with zipfile.ZipFile(zip_file, 'r') as zip_ref:
                        zip_ref.extractall(report_path)
                except FileNotFoundError:
                    print(f"ZIP file not found: {zip_file}")
                    continue
                except zipfile.BadZipFile:
                    print(f"Invalid ZIP file: {zip_file}")
                    continue

                # Process SARIF file
                report_file = os.path.join(report_path, "pmd-report.sarif")
                if os.path.exists(report_file):
                    extract_pmd(report_file, report_path)
                else:
                    print(f"PMD report not found: {report_file}")

if __name__ == "__main__":
    main()
