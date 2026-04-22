import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

        // Convert File to Path for easier handling
        Path path = file.toPath();

        // Register the file or directory to be deleted on JVM exit
        file.deleteOnExit();

        // If it's a directory, recursively register all its contents for deletion
        if (Files.isDirectory(path)) {
            Files.walk(path)
                 .sorted((p1, p2) -> -p1.compareTo(p2)) // Reverse order to delete files before directories
                 .forEach(p -> p.toFile().deleteOnExit());
        }
    }

    public static void main(String[] args) {
        try {
            // Example usage
            File file = new File("example_directory");
            forceDeleteOnExit(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}