# code_generation.py
# This script manages the code generation process for multiple programming languages, natural languages, and models.


from gpt_model import ask_Gpt
from deepseek_model import ask_deepSeek
import pandas as pd
from tqdm import tqdm
from utils import *
import logging
import os

# Set up logging configuration
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s', filename='python_generation_deepseek.log', filemode='w')

# Path to store generated files and reports
print_path = "./Data/generation"

# List of languages, programming languages, and models
languages = ['hindi', 'chinese', 'english', 'spanish', 'italian']
progamming_languages = ['python', 'java']
models = ['deepseek', 'gpt', 'claude']
iteration_number = 10  # Number of iterations for generation

def main():
    """
    Main function to manage the code generation process for multiple languages, programming languages, and models.

    This function iterates over different programming languages, languages, and models to generate code based on input
    prompts. It saves the generated code and its metadata to CSV files for each iteration.
    """
    
    # Create the main directory for storing generated data
    create_dir(print_path)
    
    # Loop through the models and programming languages
    for model in models:
        for prog_lang in progamming_languages:
            logging.info(f"Starting generation for {prog_lang} with {model}")
            
            # Loop through the languages
            for language in languages:

                logging.info(f"Starting generation for {language}")
                
                # Define the path for the CSV file containing prompts
                csv_file = f"./Data/{prog_lang}_{language}.csv"
                
                # If the CSV file does not exist, log an error and skip this iteration
                if not os.path.isfile(csv_file):
                    logging.error(f"CSV file not found: {csv_file}")
                    continue
                
                # Define the output path where generated files will be stored
                output_path = print_path + f"/{prog_lang}_{language}_{model}"
                
                # Create necessary directories
                create_dir(output_path)
                
                # Iterate over the number of required iterations
                for i in range(iteration_number):
                    data = pd.read_csv(csv_file)  # Read the CSV file containing prompts
                    logging.info(f"Starting generation for iteration {i}")

                    # Define paths for iteration-specific directories
                    iter_path = f"{output_path}/iter_{i}"
                    create_dir(iter_path)
                    report_path = f"{iter_path}/report"
                    create_dir(report_path)
                    files_path = iter_path + "/files"
                    create_dir(files_path)

                    # Loop through each prompt in the CSV file
                    for index, row in tqdm(data.iterrows(), total=data.shape[0]):
                        row_id = row['id']  # Extract the ID for the current prompt
                        
                        # Define the system prompt based on the programming language
                        if prog_lang == 'python':
                            system_prompt = """
                            You are an AI that only responds with Python code. You will be given a function signature and its docstring by the user. Write your full implementation (restate the function signature).
                            Use a Python code block to write your response. For example:
                            ```python
                            print("Hello World!")
                            ```
                            """
                        else:
                            system_prompt = """
                            You are an AI that only responds with Java code. You will be given a function signature and its docstring by the user. Write your full implementation (restate the function signature).
                            The code must be self-contained, including imports and dependencies.
                            Use a Java code block to write your response. For example:
                            ```java
                            System.out.println("Hello World!");
                            ```
                            """
                        
                        # Set the user prompt based on the language and row content
                        if language == 'english':
                            user_prompt = row['prompt']
                        else:
                            user_prompt = row['correction'] if pd.notna(row['correction']) else row['translation']

                        # Skip empty prompts
                        if pd.isna(user_prompt):
                            print("USER PROMPT EMPTY")
                            continue

                        try:
                            print(row_id)
                            print(user_prompt)
                            
                            # Generate the code using the chosen model
                            if model == 'gpt':
                                code_generated = ask_Gpt(system_prompt, user_prompt, prog_lang)
                            else:
                                code_generated = ask_deepSeek(system_prompt, user_prompt, prog_lang)
                        except Exception as e:
                            # Log any errors that occur during code generation
                            logging.error(f"Error generating code for id {row_id}: {e}")
                            continue
                        
                        # If no code was generated, log a warning and skip to the next prompt
                        if code_generated is None or code_generated == "":
                            logging.warning(f"No code generated for id {row_id}")
                            continue

                        # Save the generated code to the dataframe
                        data.at[index, 'generated_code'] = code_generated

                        # Define the file path and save the generated code to a file
                        filePath = f"{files_path}/{row_id}.{'py' if prog_lang == 'python' else 'java'}"
                        with open(filePath, "w") as f:
                            f.write(code_generated)
                            
                    # Save the updated CSV file with the generated code
                    print_file = f"{iter_path}/{prog_lang}_{language}_{model}.csv"
                    data.to_csv(print_file, index=False)

# Execute the main function when the script is run
if __name__ == "__main__":
    main()
