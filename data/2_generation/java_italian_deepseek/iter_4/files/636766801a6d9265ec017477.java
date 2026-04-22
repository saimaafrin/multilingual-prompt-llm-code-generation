import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileAdder {

    /**
     * Aggiungi i file specificati in ordine inverso.
     */
    private void addReverse(final InputStream[] files) {
        if (files == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        List<InputStream> fileList = new ArrayList<>();
        for (InputStream file : files) {
            if (file != null) {
                fileList.add(file);
            }
        }

        Collections.reverse(fileList);

        // Process the reversed list (e.g., add to a collection or perform other operations)
        for (InputStream file : fileList) {
            // Example: Add to a collection or process the file
            // processFile(file);
        }
    }

    // Example method to process a file (placeholder)
    private void processFile(InputStream file) {
        // Implement file processing logic here
    }
}