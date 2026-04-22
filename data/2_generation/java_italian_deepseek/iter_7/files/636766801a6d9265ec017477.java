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

        // Process the reversed list as needed
        for (InputStream file : fileList) {
            // Add your logic to handle the InputStream here
            // For example, you could read from the stream or add it to a collection
        }
    }
}