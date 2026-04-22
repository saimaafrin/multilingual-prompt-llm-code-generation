import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigInitializer {

    /**
     * Initialize config, such as check dist path.
     */
    public void init() {
        // Define the dist path
        String distPath = "path/to/dist";
        Path path = Paths.get(distPath);

        // Check if the dist path exists
        if (!Files.exists(path)) {
            System.out.println("Dist path does not exist. Creating directory...");
            try {
                Files.createDirectories(path);
                System.out.println("Dist path created successfully.");
            } catch (Exception e) {
                System.err.println("Failed to create dist path: " + e.getMessage());
            }
        } else {
            System.out.println("Dist path already exists.");
        }
    }

    public static void main(String[] args) {
        ConfigInitializer initializer = new ConfigInitializer();
        initializer.init();
    }
}