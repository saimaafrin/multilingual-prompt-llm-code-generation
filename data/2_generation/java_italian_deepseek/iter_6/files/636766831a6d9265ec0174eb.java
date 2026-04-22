import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileAdder {

    private List<File> fileList;

    public FileAdder() {
        this.fileList = new ArrayList<>();
    }

    /**
     * Aggiungi i file specificati in ordine inverso.
     */
    private void addReverse(final File[] files) {
        if (files == null) {
            throw new IllegalArgumentException("File array cannot be null");
        }

        // Convert array to list for easier manipulation
        List<File> tempList = new ArrayList<>();
        Collections.addAll(tempList, files);

        // Reverse the list
        Collections.reverse(tempList);

        // Add to the main list
        fileList.addAll(tempList);
    }

    public List<File> getFileList() {
        return fileList;
    }

    public static void main(String[] args) {
        FileAdder fileAdder = new FileAdder();
        File[] files = { new File("file1.txt"), new File("file2.txt"), new File("file3.txt") };
        fileAdder.addReverse(files);

        for (File file : fileAdder.getFileList()) {
            System.out.println(file.getName());
        }
    }
}