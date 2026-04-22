import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigInitializer {

    /**
     * Initialize config, such as check dist path
     */
    public void init() {
        // Define the path to check
        Path distPath = Paths.get("dist");

        // Check if the path exists
        if (Files.exists(distPath)) {
            System.out.println("Dist path exists: " + distPath.toAbsolutePath());
        } else {
            System.out.println("Dist path does not exist. Creating: " + distPath.toAbsolutePath());
            try {
                Files.createDirectories(distPath);
                System.out.println("Dist path created successfully.");
            } catch (Exception e) {
                System.err.println("Failed to create dist path: " + e.getMessage());
            }
        }
    }
}