import pandas as pd
import os
import re

# Supported natural languages for code generation analysis
languages = ['italian', 'hindi', 'chinese', 'english', 'spanish']

# Programming language to analyze
prog_lang = 'python'

# Models used for code generation
models = ['deepseek', 'gpt', 'claude']

# Number of iterations for code analysis
number_of_iteration = 10

def remove_docstrings(code: str) -> str:
    """
    Removes triple-quoted docstrings from the given Python code.

    Parameters:
    - code (str): The Python source code to process.

    Returns:
    - str: The code with docstrings removed.
    """
    code_without_docstrings = re.sub(r'"""(.*?)"""|\'\'\'(.*?)\'\'\'', '', code, flags=re.DOTALL)
    return code_without_docstrings

def main():
    """
    Main function to process generated Python code across models and languages.

    For each model and language combination:
    1. Reads the main CSV file containing the original code.
    2. Iterates through multiple code generation iterations.
    3. Removes docstrings from the generated code.
    4. Outputs the cleaned code to a JSONL file.

    Output:
    - A JSONL file with the docstring-free code for each language and model.
    """
    for model in models:
        for language in languages:
            main_file = f'./Data/{prog_lang}_{language}.csv'
            main_df = pd.read_csv(main_file)

            if 'id' in main_df.columns:
                main_df.rename(columns={'id': '_id'}, inplace=True)

            # Initialize a map to store cleaned code
            code_map = {row['_id']: [] for _, row in main_df.iterrows()}

            csv_path = f'./Data/generation/{prog_lang}_{language}_{model}'

            for iteration in range(number_of_iteration):
                print(f"Analyzing {prog_lang} with {model} for {language} for iteration {iteration}")
                read_csv_path = os.path.join(csv_path, f'iter_{iteration}', f'{prog_lang}_{language}_{model}.csv')

                df = pd.read_csv(read_csv_path)
                if 'id' in df.columns:
                    df.rename(columns={'id': '_id'}, inplace=True)

                # Process each row to remove docstrings
                for _, row in df.iterrows():
                    if row['_id'] in code_map:
                        cleaned_code = remove_docstrings(row['generated_code'])
                        code_map[row['_id']].append(cleaned_code)

            # Save the cleaned code to a JSONL file
            output_df = pd.DataFrame({
                '_id': list(code_map.keys()),
                'generate_results': list(code_map.values())
            })

            output_df.to_json(f'./Data/tests/{prog_lang}_{language}_{model}.jsonl', orient='records', lines=True)

if __name__ == '__main__':
    main()
