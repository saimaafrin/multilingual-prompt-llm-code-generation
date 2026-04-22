import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileHandler {
    /**
     * Add the specified files in reverse order.
     * @param files List of files to add in reverse order
     * @return List of files in reverse order
     */
    public List<File> addFilesInReverseOrder(List<File> files) {
        List<File> reversedFiles = new ArrayList<>(files);
        Collections.reverse(reversedFiles);
        return reversedFiles;
    }
}