import os
import shutil
import subprocess
import time
from sonarcloud_analysis import sonarCloudExtraction

# Configuration
languages = ['spanish', 'italian', 'hindi', 'chinese', 'english']
prog_lang = 'python'
models = ['deepseek', 'gpt', 'claude']
number_of_iteration = 10

# Define analyze and generation directories
analyze_dir = "/path/to/analyze"
generation_directory = "./Data/generation"

# Use environment variables for sensitive information
GITHUB_TOKEN = os.getenv("GITHUB_TOKEN", "")
REPO_URL = f"https://{GITHUB_TOKEN}@github.com/user/repo.git"
PROJECT_KEY = "user_project_key"

def main():
    """Main function to manage SonarCloud analysis."""

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
                    dest_path = os.path.join(analyze_dir, item)

                    if os.path.isdir(src_path):
                        if os.path.exists(dest_path):
                            shutil.rmtree(dest_path)  # Remove existing directory
                        shutil.copytree(src_path, dest_path)  # Copy entire directory
                    else:
                        shutil.copy2(src_path, dest_path)  # Copy individual files

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
                report_path = os.path.join(generation_directory, f"{prog_lang}_{language}_{model}", f"iter_{iteration}", "report", f"sonar_report_{language}_{prog_lang}.csv")
                sonarCloudExtraction(report_path, PROJECT_KEY)

if __name__ == "__main__":
    main()
