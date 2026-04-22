import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileProcessor {
    /**
     * Add the specified files in reverse order.
     */
    private void addReverse(final InputStream[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        List<InputStream> fileList = new ArrayList<>();
        for (InputStream file : files) {
            fileList.add(file);
        }

        Collections.reverse(fileList);

        for (InputStream file : fileList) {
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

    // Helper method to process individual files
    private void processFile(InputStream file) {
        // Implementation for processing individual files would go here
    }
}