import lizard
import pandas as pd
import os

def lizard_analysis(input_path, output_path):
    """
    Analyzes source code files in the specified input directory using Lizard.

    This function walks through the provided directory, analyzes Python (.py) and Java (.java) files using Lizard,
    and aggregates various code metrics such as lines of code (nloc), cyclomatic complexity (ccn), 
    token count, parameter count, length, and top nesting level for each function. The results are saved in a CSV file.

    Args:
        input_path (str): The path to the directory containing source code files to analyze.
        output_path (str): The path to the directory where the resulting CSV report will be saved.
    """
    data = []  # List to store the analysis results
    
    # Walk through the input directory recursively
    for root, _, files in os.walk(input_path):
        for file in files:
            # Process only Python and Java files
            if file.endswith(".py") or file.endswith(".java"):
                filepath = os.path.join(root, file)
                analysis = lizard.analyze_file(filepath)  # Perform Lizard analysis on the file

                # Initialize metrics for the entire file
                total_nloc = 0
                total_ccn = 0
                total_token_count = 0
                total_param_count = 0
                total_length = 0
                max_top_nesting_level = 0
                
                # Aggregate metrics for each function in the file
                for func in analysis.function_list:
                    total_nloc += func.nloc
                    total_ccn += func.cyclomatic_complexity
                    total_token_count += func.token_count
                    total_param_count += func.parameter_count
                    total_length += func.length
                    max_top_nesting_level = max(max_top_nesting_level, func.top_nesting_level)
                
                # Append the aggregated metrics for this file to the data list
                data.append({
                    "filename": file,
                    "nloc": total_nloc,
                    "ccn": total_ccn,
                    "token_count": total_token_count,
                    "param_count": total_param_count,
                    "length": total_length,
                    "top_nesting_level": max_top_nesting_level,
                })
                
    # Create a DataFrame from the collected data
    df = pd.DataFrame(data)
    
    # Define the path for saving the CSV report
    csv_file = os.path.join(output_path, "lizard_analysis.csv")
    
    # Save the DataFrame as a CSV file
    df.to_csv(csv_file, index=False)