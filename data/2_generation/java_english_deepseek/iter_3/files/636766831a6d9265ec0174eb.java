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
        for (File file : files) {
            fileList.add(file);
        }

        Collections.reverse(fileList);

        // Assuming you want to process the files in reverse order
        for (File file : fileList) {
            // Add your logic to process the file here
            System.out.println("Processing file: " + file.getName());
        }
    }

    public static void main(String[] args) {
        // Example usage
        File[] files = { new File("file1.txt"), new File("file2.txt"), new File("file3.txt") };
        FileAdder fileAdder = new FileAdder();
        fileAdder.addReverse(files);
    }
}