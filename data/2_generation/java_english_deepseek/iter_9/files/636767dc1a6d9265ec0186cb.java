import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigInitializer {

    private String distPath;

    public ConfigInitializer(String distPath) {
        this.distPath = distPath;
    }

    public void init() {
        try {
            Path path = Paths.get(distPath);
            if (!Files.exists(path)) {
                System.out.println("Dist path does not exist. Creating directory...");
                Files.createDirectories(path);
            } else {
                System.out.println("Dist path already exists.");
            }
        } catch (Exception e) {
            System.err.println("Error initializing config: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ConfigInitializer initializer = new ConfigInitializer("/path/to/dist");
        initializer.init();
    }
}