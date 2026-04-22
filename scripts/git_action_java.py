import os
import shutil
import subprocess
import time
import requests
from sonarcloud_analysis import sonarCloudExtraction

# Configuration
languages = ['italian', 'spanish', 'hindi', 'english', 'chinese']
prog_lang = 'java'
models = ['deepseek', 'gpt', 'claude']
number_of_iteration = 10

# Define analyze and generation directories
analyze_dir = "./TestSonarQubeJava/src/main/java/org"
generation_directory = "./Data/generation"

# All variables should be defined in the environment or as constants
GITHUB_TOKEN = os.getenv("GITHUB_TOKEN", "")
REPO_URL = f"https://{GITHUB_TOKEN}@github.com/user/repo.git"

ARTIFACT_URL = "https://api.github.com/repos/user/repo/actions/artifacts"
PROJECT_KEY = "user_project_key"

def download_pmd_report(report_path):
    """Downloads the latest PMD SARIF report from GitHub Actions artifacts."""
    headers = {'Authorization': f'token {GITHUB_TOKEN}'}

    # Fetch artifacts from the GitHub repository
    response = requests.get(ARTIFACT_URL, headers=headers)
    response.raise_for_status()

    artifacts = response.json().get('artifacts', [])

    # Filter and find the most recent PMD report
    pmd_reports = [artifact for artifact in artifacts if artifact['name'] == 'PMD Report']
    if not pmd_reports:
        raise FileNotFoundError("PMD report artifact not found.")

    pmd_reports.sort(key=lambda x: x['created_at'], reverse=True)
    most_recent_report = pmd_reports[0]

    download_url = most_recent_report['archive_download_url']

    # Download the PMD report
    print("Downloading the latest PMD report...")
    download_response = requests.get(download_url, headers=headers)
    download_response.raise_for_status()

    # Save the report locally
    report_file = os.path.join(report_path, "pmd-report.zip")
    with open(report_file, "wb") as file:
        file.write(download_response.content)
    print("PMD report downloaded successfully.")

def main():
    """Main function to manage SonarCloud and PMD analysis."""

    # Ensure correct working directory
    os.chdir("/path/to/local/repo")

    for model in models:
        for language in languages:
            for iteration in range(number_of_iteration):
                files_dir = os.path.join(generation_directory, f"{prog_lang}_{language}_{model}", f"iter_{iteration}", "files")

                # Step 1: Clean the analyze directory
                if os.path.exists(analyze_dir):
                    shutil.rmtree(analyze_dir)
                os.makedirs(analyze_dir)

                # Step 2: Copy generated files to analyze directory
                print("Copying generated files...")
                for item in os.listdir(files_dir):
                    src_path = os.path.join(files_dir, item)

                    if os.path.isfile(src_path):
                        item_name, _ = os.path.splitext(item)
                        dest_dir = os.path.join(analyze_dir, item_name)
                        os.makedirs(dest_dir, exist_ok=True)
                        shutil.copy2(src_path, os.path.join(dest_dir, item))

                # Step 3: Commit and push changes to GitHub
                subprocess.run(["git", "remote", "set-url", "origin", REPO_URL], check=True)
                subprocess.run(["git", "add", "*"], check=True)
                commit_message = f"{prog_lang} {language} iter_{iteration}"
                subprocess.run(["git", "commit", "-m", commit_message], check=True)
                subprocess.run(["git", "push"], check=True)

                # Step 4: Wait for SonarCloud analysis
                print("Waiting for SonarCloud analysis to complete...")
                time.sleep(120)

                # Step 5: Run SonarCloud extraction
                report_path = os.path.join(generation_directory, f"{prog_lang}_{language}_{model}", f"iter_{iteration}", "report")
                os.makedirs(report_path, exist_ok=True)

                sonarc_cloud_file = os.path.join(report_path, f"sonar_report_{language}_{prog_lang}.csv")
                sonarCloudExtraction(sonarc_cloud_file, PROJECT_KEY)

                # Step 6: Download PMD report
                download_pmd_report(report_path)

if __name__ == "__main__":
    main()
