import java.io.InputStream;
import java.io.IOException;
import java.util.Stack;

public class FileAdder {

    /** 
     * Add the specified files in reverse order.
     */
    private void addReverse(final InputStream[] files) {
        Stack<InputStream> stack = new Stack<>();

        // Push all files onto the stack
        for (InputStream file : files) {
            stack.push(file);
        }

        // Pop files from the stack to process them in reverse order
        while (!stack.isEmpty()) {
            InputStream file = stack.pop();
            try {
                // Here you would add the logic to process the file
                // For demonstration, we will just print the file's hash code
                System.out.println("Processing file: " + file.hashCode());
            } catch (Exception e) {
                System.err.println("Error processing file: " + e.getMessage());
            } finally {
                try {
                    file.close(); // Ensure the InputStream is closed after processing
                } catch (IOException e) {
                    System.err.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }
}