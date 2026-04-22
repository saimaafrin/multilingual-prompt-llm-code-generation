import json
import os
import anthropic
import math

# Initialize the Claude API client
client = anthropic.Anthropic()

def is_valid_json_value(value):
    """Check if a value is JSON serializable."""
    if isinstance(value, float) and (math.isnan(value) or math.isinf(value)):
        return False
    return True

def generate_code_from_prompt(json_input_path):
    # Determine the output file path in the same directory
    input_dir = os.path.dirname(json_input_path)
    json_output_file = os.path.join(input_dir, "error_regenerated_code.json")
    
    # Read the input JSON file
    with open(json_input_path, 'r', encoding='utf-8') as file:
        prompts_data = json.load(file)
    
    generated_results = []
    
    for item in prompts_data:
        task_id = item.get("ID")
        prompt_text = item.get("prompt")
        language = item.get("language")
        
        if not prompt_text:
            continue  # Skip if there's no prompt
        
        #print(f"Prompt: {prompt_text}")  # Print the prompt
        
        # Ensure all values in messages are JSON-compliant
        if not is_valid_json_value(prompt_text):
            print(f"Skipping prompt with invalid value: {prompt_text}")
            continue

        # Generate code using Claude API
        try:
            response = client.messages.create(
                model="claude-3-5-sonnet-20241022",
                max_tokens=4096,
                temperature=0,
                system= 
                    """
                    You are an AI that only responds with Python code. You will be given a function signature and its docstring by the user. Write your full implementation (restate the function signature).
                    Use a Python code block to write your response. For example:
                    ```python
                    print("Hello World!")
                    ```
                    """,
                messages=[
                    {
                        "role": "user",
                        "content": [
                            {
                                "type": "text",
                                "text": prompt_text
                            }
                        ]
                    }
                ]
            )
            
            #generated_code = response.content if response else "Error generating code"

            # Extract text properly
            if response and response.content:
                if isinstance(response.content, list):  # If response is a list, join text blocks
                    generated_code = "\n".join(block.text for block in response.content if hasattr(block, 'text'))
                else:
                    generated_code = str(response.content)
            else:
                generated_code = "Error generating code"

            #print(f"Generated Code: {generated_code}")

            # Store the result in JSON format
            generated_results.append({
                "ID": task_id,
                "prompt": prompt_text,
                "language": language,
                "generated_code": generated_code
            })
        except ValueError as e:
            print(f"Skipping due to ValueError: {e}")

    # Save the generated results to a JSON file
    with open(json_output_file, 'w', encoding='utf-8') as file:
        json.dump(generated_results, file, indent=4, ensure_ascii=False)
    
    print(f"Generated code saved to {json_output_file}")

# Example usage
input_file = "./Multilingual-Ability-LLM/errors_regenerated.json"
generate_code_from_prompt(input_file)
