import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

private void addReverse(final File[] files) {
    if (files == null || files.length == 0) {
        return;
    }

    // Convert the array to a list for easier manipulation
    List<File> fileList = new ArrayList<>();
    for (File file : files) {
        fileList.add(file);
    }

    // Reverse the list
    Collections.reverse(fileList);

    // Process the files in reverse order
    for (File file : fileList) {
        // Add your logic here to process each file
        // For example, you might add them to a collection or perform some operation
        System.out.println("Processing file: " + file.getName());
    }
}