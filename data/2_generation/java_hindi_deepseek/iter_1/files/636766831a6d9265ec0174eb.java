import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

private void addReverse(final File[] files) {
    Stack<String> stack = new Stack<>();
    
    // Read all files and push their content into the stack
    for (File file : files) {
        try (java.util.Scanner scanner = new java.util.Scanner(file)) {
            while (scanner.hasNextLine()) {
                stack.push(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Write the content in reverse order to a new file
    try (FileWriter writer = new FileWriter("reversed_output.txt")) {
        while (!stack.isEmpty()) {
            writer.write(stack.pop() + System.lineSeparator());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}