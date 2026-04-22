from flake_analysis import flake_analysis
from pylint_analysis import pylint_analysis
from lizard_analysis import lizard_analysis
from utils import create_dir
import pandas as pd

# Supported natural languages for code generation analysis
languages = ['italian', 'hindi', 'chinese', 'english', 'spanish']

# Supported programming languages for analysis
progamming_languages = ['python', 'java']

# Models used for code generation
models = ['deepseek', 'gpt', 'claude']

# Number of iterations for each analysis
iteration_number = 10

def main():
    """
    Executes static code analysis on generated code files for multiple models, languages, and programming languages.

    For each combination of model, programming language, and natural language, the function iterates through multiple
    generations and performs various static analyses (Flake8, Pylint, Lizard) depending on the programming language.

    - Python: Executes Flake8, Pylint, and Lizard analyses.
    - Java: Executes only the Lizard analysis.

    Reports are stored in a dedicated directory for each iteration.
    """
    for model in models:
        for prog_lang in progamming_languages:
            for language in languages:
                print(f"Analyzing {prog_lang} with {model} for {language}")
                for i in range(iteration_number):
                    files_path = f"./Data/generation/{prog_lang}_{language}_{model}/iter_{i}/files/"
                    report_path = f"./Data/generation/{prog_lang}_{language}_{model}/iter_{i}/report/"

                    # Ensure the report directory exists
                    create_dir(report_path)

                    if prog_lang == 'python':
                        try:
                            print(f"Starting Flake analysis for iteration {i}")
                            flake_analysis(files_path, report_path)

                            print(f"Starting Lizard analysis for iteration {i}")
                            lizard_analysis(files_path, report_path)

                            print(f"Starting Pylint analysis for iteration {i}")
                            pylint_analysis(files_path, report_path)
                        except Exception as e:
                            print(f"Error during analysis for iteration {i}: {e}")
                    else:  # Java case
                        try:
                            print(f"Starting Lizard analysis for iteration {i}")
                            lizard_analysis(files_path, report_path)
                        except Exception as e:
                            print(f"Error during analysis for iteration {i}: {e}")

if __name__ == "__main__":
    main()
