import java.io.File;

public class FileManager {

    /** 
     * 以逆序添加指定的文件。
     */
    private void addReverse(final File[] files) {
        if (files == null || files.length == 0) {
            return;
        }
        
        for (int i = files.length - 1; i >= 0; i--) {
            addFile(files[i]);
        }
    }

    private void addFile(File file) {
        // Implementation for adding a file
        System.out.println("Adding file: " + file.getName());
    }

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        File[] files = { new File("file1.txt"), new File("file2.txt"), new File("file3.txt") };
        fileManager.addReverse(files);
    }
}