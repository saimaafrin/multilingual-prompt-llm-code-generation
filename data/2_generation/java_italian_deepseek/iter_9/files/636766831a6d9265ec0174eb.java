import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class FileAdder {

    /**
     * Aggiungi i file specificati in ordine inverso.
     */
    private void addReverse(final File[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        List<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);
        Collections.reverse(fileList);

        // Example of processing the reversed list
        for (File file : fileList) {
            System.out.println(file.getName());
        }
    }

    public static void main(String[] args) {
        File[] files = { new File("file1.txt"), new File("file2.txt"), new File("file3.txt") };
        FileAdder fileAdder = new FileAdder();
        fileAdder.addReverse(files);
    }
}