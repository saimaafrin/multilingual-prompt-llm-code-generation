import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileAdder {

    /**
     * Aggiungi i file specificati in ordine inverso.
     */
    private void addReverse(final File[] files) {
        if (files == null) {
            throw new IllegalArgumentException("File array cannot be null");
        }

        List<File> fileList = new ArrayList<>();
        for (File file : files) {
            if (file != null) {
                fileList.add(file);
            }
        }

        Collections.reverse(fileList);

        // Example of processing the reversed list
        for (File file : fileList) {
            System.out.println("Processing file: " + file.getName());
            // Add your logic here to process the files
        }
    }

    public static void main(String[] args) {
        // Example usage
        File[] files = { new File("file1.txt"), new File("file2.txt"), new File("file3.txt") };
        FileAdder fileAdder = new FileAdder();
        fileAdder.addReverse(files);
    }
}