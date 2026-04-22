import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

private void addReverse(final File[] files) {
    if (files == null || files.length == 0) {
        return;
    }

    List<File> fileList = new ArrayList<>();
    for (File file : files) {
        fileList.add(file);
    }

    Collections.reverse(fileList);

    // Assuming there is a method to add files, replace 'addFile' with the actual method name
    for (File file : fileList) {
        addFile(file); // Replace 'addFile' with the actual method to add files
    }
}

// Example method to add a file (replace with actual implementation)
private void addFile(File file) {
    // Implementation to add the file
    System.out.println("Adding file: " + file.getName());
}