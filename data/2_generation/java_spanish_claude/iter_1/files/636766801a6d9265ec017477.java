import java.io.InputStream;
import java.util.Stack;
import java.io.IOException;

public class FileProcessor {

    /**
     * Agrega los archivos especificados en orden inverso.
     */
    private void addReverse(final InputStream[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        Stack<InputStream> stack = new Stack<>();
        
        // Push files to stack to reverse order
        for (InputStream file : files) {
            if (file != null) {
                stack.push(file);
            }
        }

        // Process files in reverse order
        while (!stack.isEmpty()) {
            InputStream currentFile = stack.pop();
            try {
                processFile(currentFile);
            } catch (IOException e) {
                // Handle exception appropriately
                e.printStackTrace();
            } finally {
                try {
                    currentFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Helper method to process individual files
    private void processFile(InputStream file) throws IOException {
        // Add file processing logic here
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = file.read(buffer)) != -1) {
            // Process bytes as needed
        }
    }
}