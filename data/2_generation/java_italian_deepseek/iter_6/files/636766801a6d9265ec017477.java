import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileAdder {

    private List<InputStream> fileList;

    public FileAdder() {
        this.fileList = new ArrayList<>();
    }

    /**
     * Aggiungi i file specificati in ordine inverso.
     */
    private void addReverse(final InputStream[] files) {
        if (files == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        // Add files to the list in reverse order
        for (int i = files.length - 1; i >= 0; i--) {
            if (files[i] != null) {
                fileList.add(files[i]);
            }
        }
    }

    // Optional: Method to get the list of files (for testing or further processing)
    public List<InputStream> getFileList() {
        return Collections.unmodifiableList(fileList);
    }
}