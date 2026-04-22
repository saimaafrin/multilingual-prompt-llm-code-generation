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
        
        // Add files to stack in reverse order
        for (int i = files.length - 1; i >= 0; i--) {
            if (files[i] != null) {
                stack.push(files[i]);
            }
        }
        
        // Process files in reverse order
        while (!stack.isEmpty()) {
            InputStream file = stack.pop();
            processFile(file);
        }
    }
    
    // Helper method to process individual files
    private void processFile(InputStream file) {
        try {
            // Process the file stream
            // Implementation details would go here
            file.close();
        } catch (Exception e) {
            // Handle exceptions
        }
    }
}