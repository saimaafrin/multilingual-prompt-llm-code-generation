import subprocess
import pandas as pd
import os

def pylint_analysis(input_path, output_path):
    """
    Runs Pylint analysis on the specified Python files and generates a CSV report.

    This function executes the Pylint tool on the provided input path, collects the analysis results in JSON format, 
    and parses the output into a pandas DataFrame. It groups the errors by module, merges the symbols and messages, 
    counts the number of errors per module, and saves the results in a CSV file.

    Args:
        input_path (str): Path to the directory or file to be analyzed by Pylint.
        output_path (str): Path to the directory where the analysis report (CSV) will be saved.
    """
    
    # Ensure output directory exists
    os.makedirs(output_path, exist_ok=True)

    # Print statement to indicate the start of the analysis
    print(f"Running pylint analysis on {input_path}...")
    
    # Set the output path for the JSON result of pylint
    json_output_path = os.path.join(output_path, "pylint_output.json")
    
    # Make input_path an absolute path
    input_path = os.path.abspath(input_path)

    # Run pylint with JSON output format and write the results to a file
    with open(json_output_path, "w") as jsonfile:
        command = ["pylint", "--output-format=json", input_path]
        try:
            subprocess.run(command, stdout=jsonfile, stderr=subprocess.PIPE, text=True, check=True)
        except subprocess.CalledProcessError as e:
            # Catch and handle errors in the subprocess call
            print(f"Error running Pylint: {e}")
            return

    # Try to parse the JSON output into a pandas DataFrame
    try:
        errors = pd.read_json(json_output_path)
        
        # If there are no errors found, print a message and return
        if errors.empty:
            print("No pylint issues found.")
            return
    except (ValueError, FileNotFoundError) as e:
        print(f"Error reading Pylint output: {e}")
        return

    # Group the errors by module, merging the symbols and messages
    errors_grouped = errors.groupby('module').agg({
        'symbol': lambda x: ', '.join(x),  # Merge all symbols with a comma separator
        'message': lambda x: ' | '.join(x),  # Merge all messages with a '|' separator
    }).reset_index()

    # Add a count column to show the number of errors per module
    errors_grouped['count'] = errors.groupby('module').size().values

    # Define the CSV output path and save the grouped results
    csv_output_path = os.path.join(output_path, "pylint_report.csv")
    errors_grouped.to_csv(csv_output_path, index=False, header=["module", "error_ids", "error_messages", "count"])

    # Print a message indicating the completion of the analysis
    print(f"Pylint analysis complete. Report saved as {csv_output_path}.")

