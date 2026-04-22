import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class FileAdder {

    /**
     * Add the specified files in reverse order.
     */
    private void addReverse(final InputStream[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        // Convert the array to a list for easier manipulation
        List<InputStream> fileList = new ArrayList<>();
        for (InputStream file : files) {
            fileList.add(file);
        }

        // Reverse the list
        Collections.reverse(fileList);

        // Process the files in reverse order
        for (InputStream file : fileList) {
            // Add your logic here to process each file
            // For example, you might want to read from the InputStream
            // or perform some other operation.
        }
    }
}