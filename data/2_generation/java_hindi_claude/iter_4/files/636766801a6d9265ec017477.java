import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileHandler {
    /**
     * Add the specified files in reverse order.
     * @param files Array of files to add in reverse order
     * @return List of files in reverse order
     */
    public List<File> addFilesInReverse(File[] files) {
        List<File> reversedFiles = new ArrayList<>();
        
        // Add files to list
        for (File file : files) {
            reversedFiles.add(file);
        }
        
        // Reverse the list
        Collections.reverse(reversedFiles);
        
        return reversedFiles;
    }
}