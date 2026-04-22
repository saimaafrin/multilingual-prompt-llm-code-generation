import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class FileAdder {

    /**
     * Add the specified files in reverse order.
     */
    private void addReverse(final File[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        List<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);
        Collections.reverse(fileList);

        // Assuming there is a method to add files, e.g., addFile(File file)
        for (File file : fileList) {
            addFile(file);
        }
    }

    // Dummy method to simulate adding a file
    private void addFile(File file) {
        // Implementation to add the file
        System.out.println("Adding file: " + file.getName());
    }

    public static void main(String[] args) {
        FileAdder fileAdder = new FileAdder();
        File[] files = { new File("file1.txt"), new File("file2.txt"), new File("file3.txt") };
        fileAdder.addReverse(files);
    }
}