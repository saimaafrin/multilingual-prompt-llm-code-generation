import java.io.InputStream;
import java.util.Stack;

public class FileAdder {

    /** 
     * Agrega los archivos especificados en orden inverso.
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
            // Here you would add the logic to process the file
            // For example, read from the InputStream and add it to a collection
            processFile(file);
        }
    }

    private void processFile(InputStream file) {
        // Implement the logic to process the InputStream
        // This is a placeholder for demonstration purposes
        System.out.println("Processing file: " + file);
    }
}