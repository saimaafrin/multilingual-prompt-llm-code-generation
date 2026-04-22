from openai import OpenAI
from colorama import Fore, Style
from utils import extract_code_snippet

# Initialize OpenAI client with the provided API key.
client = OpenAI(api_key="")

def ask_Gpt(system_prompt, user_prompt, language):
    """
    Interacts with the GPT-4 model to process user prompts and return code snippets.
    
    This function sends a system prompt and a user prompt to the GPT-4 model, requesting 
    a completion based on the given language and instructions. The response is then 
    processed to extract relevant code snippets using a utility function.

    Args:
        system_prompt (str): The system-level instructions for GPT (e.g., context, rules).
        user_prompt (str): The user's specific query or request to be processed by GPT.
        language (str): The programming language in which the code snippet is expected.

    Returns:
        str: A code snippet extracted from the GPT-4 response, tailored to the specified language.
    """
    
    # Request completion from GPT-4 with the provided system and user prompts.
    completion = client.chat.completions.create(
        model="gpt-4o-mini",  # Use the specific GPT-4 variant for the request.
        temperature=0,        # Set to 0 for deterministic output.
        seed=2025,            # Seed for reproducibility of results.
        n=1,                  # Request only one completion.
        messages=[
            # System prompt to instruct the model on how to respond.
            {"role": "system", "content": system_prompt},
            # User's query to be processed.
            {"role": "user", "content": user_prompt}
        ]
    )
    
    # Extract the response message content from the GPT-4 completion.
    message = completion.choices[0].message.content
    
    # Extract the relevant code snippet from the response.
    extracted_code = extract_code_snippet(message, language)
    
    # Print the extracted code snippet with color formatting for better visibility.
    print(f"{Fore.LIGHTBLUE_EX}{extracted_code}{Style.RESET_ALL}\n")
    
    # Return the extracted code snippet for further use.
    return extracted_code
