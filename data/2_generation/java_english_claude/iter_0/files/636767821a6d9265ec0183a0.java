import java.io.File;

public class FileUtils {
    /**
     * Delete's the specified file if it exists
     */
    protected static void deleteFile(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
        }
    }
}