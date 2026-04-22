import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigInitializer {

    /**
     * Initialize config, such as check dist path
     */
    public void init() {
        // Define the path to check
        String distPath = "path/to/dist";
        Path path = Paths.get(distPath);

        // Check if the path exists
        if (Files.exists(path)) {
            System.out.println("Dist path exists: " + distPath);
        } else {
            System.out.println("Dist path does not exist: " + distPath);
            // Optionally, create the directory if it doesn't exist
            try {
                Files.createDirectories(path);
                System.out.println("Created dist path: " + distPath);
            } catch (Exception e) {
                System.err.println("Failed to create dist path: " + e.getMessage());
            }
        }
    }
}