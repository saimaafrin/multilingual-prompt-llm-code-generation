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
        Path path = Paths.get(distPath);
        if (!Files.exists(path)) {
            System.err.println("Dist path does not exist: " + distPath);
            return;
        }
        if (!Files.isDirectory(path)) {
            System.err.println("Dist path is not a directory: " + distPath);
            return;
        }
        System.out.println("Dist path is valid: " + distPath);
    }

    public static void main(String[] args) {
        ConfigInitializer initializer = new ConfigInitializer("/path/to/dist");
        initializer.init();
    }
}