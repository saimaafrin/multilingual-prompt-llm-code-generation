import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileHandler {
    /**
     * Add the specified files in reverse order.
     * @param files Array of files to add
     * @return List of files in reverse order
     */
    public List<File> addFilesInReverseOrder(File[] files) {
        List<File> fileList = new ArrayList<>();
        
        // Add files to list
        for (File file : files) {
            fileList.add(file);
        }
        
        // Reverse the list
        Collections.reverse(fileList);
        
        return fileList;
    }
}