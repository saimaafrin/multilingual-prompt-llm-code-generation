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
        
        // Pop files from the stack to add them in reverse order
        while (!stack.isEmpty()) {
            InputStream file = stack.pop();
            // Here you would add the file to your desired structure
            // For demonstration, we will just print the file reference
            System.out.println("Adding file: " + file);
        }
    }
}