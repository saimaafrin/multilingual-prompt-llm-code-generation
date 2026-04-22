from openai import OpenAI
from colorama import Fore, Style
from utils import extract_code_snippet

def ask_deepSeek(system_prompt, user_prompt, language):
    """
    Sends a chat request to the DeepSeek API and extracts code snippets from the response.

    Parameters:
    - system_prompt (str): The system-level prompt to guide the model's behavior.
    - user_prompt (str): The user's input prompt to the model.
    - language (str): The programming language of the code snippet to extract.

    Returns:
    - str or None: The extracted code snippet if successful, or None if an error occurs.

    Side Effects:
    - Prints the extracted code snippet to the console.
    - Prints an error message in case of an exception.
    """

    client = OpenAI(api_key="", base_url="https://api.deepseek.com")
    try:
        # Send a chat request to the DeepSeek API
        response = client.chat.completions.create(
            model="deepseek-chat",
            temperature=0,
            seed=2025,
            messages=[
                {"role": "system", "content": system_prompt},
                {"role": "user", "content": user_prompt},
            ],
            stream=False
        )

        # Extract and display the code snippet
        message = response.choices[0].message.content
        extracted_code = extract_code_snippet(message, language)
        print(f"{Fore.LIGHTBLUE_EX}{extracted_code}{Style.RESET_ALL}\n")

        return extracted_code
    except Exception as e:
        # Handle and display any errors
        print(f"{Fore.RED}Error: {e}{Style.RESET_ALL}")
        return None