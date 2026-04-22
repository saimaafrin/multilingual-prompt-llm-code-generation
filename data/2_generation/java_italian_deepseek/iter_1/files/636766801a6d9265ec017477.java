import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileAdder {

    private List<InputStream> fileList;

    public FileAdder() {
        fileList = new ArrayList<>();
    }

    /**
     * Aggiungi i file specificati in ordine inverso.
     */
    private void addReverse(final InputStream[] files) {
        if (files == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        // Convert the array to a list for easier manipulation
        List<InputStream> tempList = new ArrayList<>();
        for (InputStream file : files) {
            if (file != null) {
                tempList.add(file);
            }
        }

        // Reverse the list
        Collections.reverse(tempList);

        // Add the reversed list to the main file list
        fileList.addAll(tempList);
    }

    // Optional: Method to get the file list for verification
    public List<InputStream> getFileList() {
        return fileList;
    }
}