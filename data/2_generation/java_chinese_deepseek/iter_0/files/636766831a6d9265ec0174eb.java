import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class FileHandler {

    /**
     * 以逆序添加指定的文件。
     */
    private void addReverse(final File[] files) {
        if (files == null) {
            return;
        }

        List<File> fileList = new ArrayList<>();
        for (File file : files) {
            if (file != null) {
                fileList.add(file);
            }
        }

        Collections.reverse(fileList);

        // Assuming there is a method to handle the reversed list of files
        handleFiles(fileList);
    }

    private void handleFiles(List<File> files) {
        // Implementation to handle the list of files
        for (File file : files) {
            System.out.println("Processing file: " + file.getName());
        }
    }

    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        File[] files = { new File("file1.txt"), new File("file2.txt"), new File("file3.txt") };
        handler.addReverse(files);
    }
}