import re, json, os
import tiktoken

def create_dir(path):
    """
    Create a directory if it doesn't already exist.

    Args:
        path (str): The directory path to create.
    """
    if not os.path.exists(path):
        os.makedirs(path)

def num_tokens_from_string(string: str) -> int:
    """
    Count the number of tokens in a string using GPT-4o model's encoding.

    Args:
        string (str): The string to count tokens for.

    Returns:
        int: The number of tokens in the string.
    """
    encoding = tiktoken.encoding_for_model("gpt-4o")
    num_tokens = len(encoding.encode(string))
    return num_tokens

def extract_code_snippet(text: str, language) -> str:
    """
    Extract the code snippet from a given text based on the specified programming language.

    Args:
        text (str): The input text that contains the code snippet.
        language (str): The programming language of the code snippet (e.g., 'python', 'java').

    Returns:
        str or None: The extracted code snippet if found, otherwise None.
    """
    pattern = rf"```{language}(.*?)```"
    match = re.search(pattern, text, re.DOTALL)
    
    if match:
        return match.group(1).strip()  # Return the code snippet found within the code block
    return None

def extract_function_signature(code):
    """
    Extract the function signature from a block of code. 

    Args:
        code (str): The code string to extract the function signature from.

    Returns:
        str or None: The function signature, or None if no match is found.
    """
    # Regular expression to match the function signature and the docstring
    pattern = r"def.*?:\n"
    match = re.search(pattern, code, re.DOTALL)
    
    if match:
        return match.group(0)  # Return the function signature including the docstring
    else:
        # If no docstring is found, try matching just the function signature
        pattern = r"def.*?: "
        match = re.search(pattern, code, re.DOTALL)

        if match:
            return match.group(0)  # Return the function signature without the docstring
        return None

def read_json_file(file_path):
    """
    Read data from a JSON file and return the content.

    Args:
        file_path (str): The path to the JSON file to be read.

    Returns:
        dict: The content of the JSON file as a dictionary.
    """
    with open(file_path, 'r') as file:
        data = json.load(file)  # Load the JSON data into a Python dictionary
    return data

def getSignaturePython(method_code):
    """
    Extract the function signature from a Python method code, excluding imports.

    Args:
        method_code (str): The Python method code from which the signature will be extracted.

    Returns:
        str: The function signature.
    """
    method_code = method_code.strip()
    
    # Remove lines that are imports
    lines = [line for line in method_code.split("\n") if not (line.strip().startswith("import") or line.strip().startswith("from"))]

    signature_line = ""
    for line in lines:
        signature_line += line.strip()
        if ":" in line:  # Break when we find the function signature line (ending with ':')
            break

    return signature_line

def extract_model_prog(filename: str) -> str:
    """
    Extract the model and programming language from a filename formatted as 'model-language'.

    Args:
        filename (str): The filename in the format 'model-language'.

    Returns:
        tuple: A tuple containing the model and the programming language.
    """
    return filename.split("-")[1], filename.split("-")[0]
