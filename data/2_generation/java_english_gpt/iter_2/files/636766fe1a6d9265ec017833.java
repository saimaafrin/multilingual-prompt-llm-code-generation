import java.io.File;
import java.io.IOException;

public class FileDeleter {

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
            deleteDirectory(file);
        } else {
            if (!file.delete()) {
                throw new IOException("Failed to delete file: " + file.getAbsolutePath());
            }
        }
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        deleteDirectory(file);
                    } else {
                        if (!file.delete()) {
                            System.err.println("Failed to delete file on exit: " + file.getAbsolutePath());
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println("Error during file deletion on exit: " + e.getMessage());
            }
        }));
    }

    private static void deleteDirectory(File directory) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    if (!file.delete()) {
                        throw new IOException("Failed to delete file: " + file.getAbsolutePath());
                    }
                }
            }
        }
        if (!directory.delete()) {
            throw new IOException("Failed to delete directory: " + directory.getAbsolutePath());
        }
    }
}