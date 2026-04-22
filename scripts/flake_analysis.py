import subprocess
import pandas as pd

def flake_analysis(input_path, output_path):
    """
    Performs static code analysis using flake8 on the specified input path and
    generates a CSV report of the errors.

    Args:
        input_path (str): The path to the directory containing Python files to analyze.
        output_path (str): The directory where the CSV report will be saved.

    Outputs:
        A CSV report summarizing the flake8 errors, including filenames, error codes,
        error messages, and the count of errors for each file.
    """
    # Define the flake8 command with custom output format
    command = ['flake8', '--format=%(path)s,%(code)s,%(text)s', input_path]

    # Execute the flake8 command and capture the output
    result = subprocess.run(command, capture_output=True, text=True)

    # Initialize a list to store parsed error data
    data = []

    # Process the flake8 output, splitting each line into components
    for line in result.stdout.strip().split('\n'):
        if not line:
            continue  # Skip empty lines

        try:
            filename, error_id, error_message = line.split(',', 2)
            data.append([filename, error_id, error_message])
        except ValueError:
            print(f"Warning: Unable to parse line: {line}")

    # If no errors were found, exit early
    if not data:
        print("flake8 analysis complete. No issues found.")
        return

    # Convert the collected data to a pandas DataFrame
    df = pd.DataFrame(data, columns=['filename', 'error_id', 'error_message'])

    # Group errors by filename and aggregate error details
    agg_df = df.groupby('filename').agg(
        error_ids=('error_id', ' ; '.join),  # Combine error IDs
        error_messages=('error_message', ' ; '.join),  # Combine error messages
        count=('error_id', 'size')  # Count number of errors
    ).reset_index()

    # Ensure output directory exists
    output_file = f"{output_path}/flake8_report.csv"

    # Save the aggregated DataFrame to a CSV file
    agg_df.to_csv(output_file, index=False)

    print(f"flake8 analysis complete. Report saved as {output_file}.")

