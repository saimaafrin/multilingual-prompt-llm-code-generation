import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileHandler {

    /**
     * Aggiungi i file specificati in ordine inverso.
     */
    private void addReverse(final InputStream[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        List<InputStream> fileList = new ArrayList<>();
        
        // Add files to list
        for (InputStream file : files) {
            if (file != null) {
                fileList.add(file);
            }
        }

        // Reverse the list
        Collections.reverse(fileList);

        // Process files in reverse order
        for (InputStream file : fileList) {
            try {
                // Add file contents (implementation depends on specific needs)
                processFile(file);
            } catch (Exception e) {
                // Handle exceptions appropriately
                e.printStackTrace();
            } finally {
                try {
                    file.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Helper method to process individual files
    private void processFile(InputStream file) throws Exception {
        // Implementation depends on specific requirements
        // Example: read file contents, add to collection, etc.
    }
}