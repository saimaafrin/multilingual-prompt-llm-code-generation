import java.io.File;
import java.io.IOException;

public class FileUtils {

    /**
     * Schedules a file to be deleted when JVM exits. If file is directory delete it and all sub-directories.
     * @param file  file or directory to delete, must not be {@code null}
     * @throws NullPointerException if the file is {@code null}
     * @throws IOException in case deletion is unsuccessful
     */
    public static void forceDeleteOnExit(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }

        if (file.isDirectory()) {
            // Delete contents of directory first
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    forceDeleteOnExit(f);
                }
            }
        }
        
        file.deleteOnExit();
    }
}