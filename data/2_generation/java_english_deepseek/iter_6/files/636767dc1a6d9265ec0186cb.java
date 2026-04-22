import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigInitializer {

    private String distPath;

    public ConfigInitializer(String distPath) {
        this.distPath = distPath;
    }

    /**
     * Initialize config, such as check dist path
     */
    public void init() {
        if (distPath == null || distPath.isEmpty()) {
            throw new IllegalArgumentException("Distribution path cannot be null or empty.");
        }

        Path path = Paths.get(distPath);
        if (!Files.exists(path)) {
            throw new IllegalStateException("Distribution path does not exist: " + distPath);
        }

        if (!Files.isDirectory(path)) {
            throw new IllegalStateException("Distribution path is not a directory: " + distPath);
        }

        System.out.println("Config initialized successfully. Distribution path: " + distPath);
    }

    public static void main(String[] args) {
        ConfigInitializer initializer = new ConfigInitializer("/path/to/dist");
        initializer.init();
    }
}