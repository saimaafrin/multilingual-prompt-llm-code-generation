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
        for (File file : files) {
            fileList.add(file);
        }
        
        Collections.reverse(fileList);
        
        for (File file : fileList) {
            add(file);
        }
    }
    
    // Helper method to add individual files
    private void add(File file) {
        // Implementation of add method would go here
        // This is just a stub since the original implementation is not provided
    }
}