import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileHandler {
    
    /**
     * Aggiungi i file specificati in ordine inverso.
     */
    private void addReverse(final File[] files) {
        if (files == null || files.length == 0) {
            return;
        }
        
        List<File> fileList = new ArrayList<>();
        
        // Add files to list
        for (File file : files) {
            if (file != null) {
                fileList.add(file);
            }
        }
        
        // Reverse the list
        Collections.reverse(fileList);
        
        // Process files in reverse order
        for (File file : fileList) {
            processFile(file);
        }
    }
    
    // Helper method to process individual files
    private void processFile(File file) {
        // Implementation for processing individual files would go here
        // Left empty as it wasn't part of the original requirements
    }
}