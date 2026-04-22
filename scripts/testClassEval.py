import os
import pandas as pd
from Data.benchmark.classEval import ClassEval

# Supported natural languages for code generation analysis
languages = ['italian', 'hindi', 'chinese', 'english', 'spanish']

# Supported programming languages for analysis
progamming_languages = ['python']

# Models used for code generation
models = ['gpt', 'deepseek', 'claude']

# Number of iterations for each analysis
iteration_number = 10

def export_jsonl(row, output_file):
    with open(output_file, 'a') as f:
        f.write(row.to_json() + '\n')

if __name__ == "__main__":
    for model in models:
        for prog_lang in progamming_languages:
            for language in languages:
                dir_name = f"{prog_lang}_{language}_{model}"
                for i in range(iteration_number):
                    iteration_dir = f"./Data/generation/{prog_lang}_{language}_{model}/iter_{i}"
                    testData_path = os.path.join(iteration_dir, "testData.json")
                    benchmark = ClassEval()
                    benchmark_df = benchmark.load_data(testData_path)

                    passed = 0
                    for index, row in benchmark_df.iterrows():
                        print(f"Processing Task ID {row['task_id']}")
                        benchmark.row = row
                        prediction = row['predict']
                        status, output = benchmark.run_tests(prediction)

                        if status == True: passed += 1

                        '''
                        if status == False:
                            print(f"Test Output:\n{output}")
                            print(f"Passed: {status}\n")
                        '''
                        # Export the results to a JSONL file in append mode
                        row['evaluated_tests'] = benchmark.tests()
                        row['completion'] = prediction
                        row['test_output'] = output
                        row['passed'] = status
                        export_jsonl(row, os.path.join(iteration_dir, f"result.jsonl"))
                    print(f"Directory: {iteration_dir} - Passed {passed} out of {len(benchmark_df)} tests\n")
        