import java.io.File;

public class FileAdder {
    
    /** 
     * Add the specified files in reverse order.
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
        // Implementation for adding the file
        System.out.println("Adding file: " + file.getName());
    }
}