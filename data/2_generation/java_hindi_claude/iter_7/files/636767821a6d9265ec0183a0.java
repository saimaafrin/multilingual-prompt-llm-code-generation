import java.io.File;
import java.io.IOException;

public class FileDeleter {
    /**
     * Delete's the specified file if it exists
     * @param filePath The path to the file to delete
     * @return true if file was deleted successfully, false if file doesn't exist or couldn't be deleted
     */
    public boolean deleteFile(String filePath) {
        File fileToDelete = new File(filePath);
        if (fileToDelete.exists()) {
            return fileToDelete.delete();
        }
        return false;
    }
}