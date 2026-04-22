import requests
import pandas as pd

# SonarCloud API base URL
SONARCLOUD_API = "https://sonarcloud.io/api"

# Metrics to fetch from SonarCloud, including code smells, vulnerabilities, bugs, and security hotspots
METRICS = "comment_lines_density,comment_lines,ncloc,statements,complexity,cognitive_complexity,code_smells,vulnerabilities,bugs,security_hotspots"

def fetch_metrics(PROJECT_KEY):
    """
    Fetch file-level metrics from SonarCloud for a given project.

    Args:
        PROJECT_KEY (str): The unique key for the SonarCloud project.

    Returns:
        dict: JSON response from the SonarCloud API containing the requested metrics.
    """
    url = f"{SONARCLOUD_API}/measures/component_tree"
    params = {
        "component": PROJECT_KEY,
        "metricKeys": METRICS,
        "ps": 500  # Max 500 components per request
    }
    
    # Send GET request to the SonarCloud API and raise error for unsuccessful status
    response = requests.get(url, params=params)
    response.raise_for_status()
    return response.json()

def process_data(data):
    """
    Convert the API response data to a Pandas DataFrame.

    Args:
        data (dict): The JSON response from SonarCloud API.

    Returns:
        pd.DataFrame: DataFrame containing the processed metrics.
    """
    components = data.get("components", [])
    
    if not components:
        print("No data found.")
        return pd.DataFrame()  # Return empty DataFrame if no components are found
    
    records = []
    for component in components:
        file_name = component.get("path", component.get("key", "Unknown"))
        file_name = file_name.replace("analyze/", "")
        file_name = file_name.replace(".py", "")  # Optional: Remove file extension if needed
        
        # Extract the metrics for each component
        metrics = {m["metric"]: m["value"] for m in component.get("measures", [])}
        
        # Prepare the record for the current component
        records.append([
            file_name,
            metrics.get("comment_lines_density", "N/A"),
            metrics.get("comment_lines", "N/A"),
            metrics.get("ncloc", "N/A"),
            metrics.get("statements", "N/A"),
            metrics.get("complexity", "N/A"),
            metrics.get("cognitive_complexity", "N/A"),
            metrics.get("code_smells", "N/A"),
            metrics.get("vulnerabilities", "N/A"),
            metrics.get("bugs", "N/A"),
            metrics.get("security_hotspots", "N/A")
        ])
    
    # Return a DataFrame containing the aggregated metrics for all components
    return pd.DataFrame(records, columns=["File", "Comment (%)", "Comment Lines", "Lines of Code", 
                                          "Statements", "Cyclomatic Complexity", "Cognitive Complexity", 
                                          "Code Smells", "Vulnerabilities", "Bugs", "Security Hotspots"])

def save_to_csv(df, printPath):
    """
    Save the DataFrame to a CSV file.

    Args:
        df (pd.DataFrame): The DataFrame containing the metrics.
        printPath (str): The file path where the CSV will be saved.
    """
    df.to_csv(printPath, index=False)
    print(f"CSV saved as {printPath}")

def sonarCloudExtraction(printPath, PROJECT_KEY):
    """
    Fetch SonarCloud metrics, process the data, and save it as a CSV file.

    Args:
        printPath (str): The file path where the resulting CSV will be saved.
        PROJECT_KEY (str): The unique key for the SonarCloud project.
    """
    # Fetch metrics from SonarCloud for the given project key
    data = fetch_metrics(PROJECT_KEY)
    
    # Process the fetched data and convert it to a DataFrame
    df = process_data(data)
    
    # If the DataFrame is not empty, save it to a CSV file
    if not df.empty:
        save_to_csv(df, printPath)
