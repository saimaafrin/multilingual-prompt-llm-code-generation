import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;

public class FileProcessor {

    /**
     * Add the specified files in reverse order.
     */
    private void addReverse(final InputStream[] files) {
        if (files == null || files.length == 0) {
            return;
        }
        
        Deque<InputStream> stack = new ArrayDeque<>();
        
        // Add files to stack in original order
        for (InputStream file : files) {
            if (file != null) {
                stack.push(file);
            }
        }
        
        // Process files in reverse order
        while (!stack.isEmpty()) {
            InputStream file = stack.pop();
            try {
                processFile(file);
            } finally {
                try {
                    file.close();
                } catch (Exception e) {
                    // Handle or log exception
                }
            }
        }
    }
    
    // Helper method to process individual file
    private void processFile(InputStream file) {
        // Implementation for processing individual file
        // would go here
    }
}