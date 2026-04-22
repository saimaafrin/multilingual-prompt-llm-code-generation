import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigInitializer {

    /**
     * initialize config, such as check dist path
     */
    public void initializeConfig() {
        // Check and create dist directory if it doesn't exist
        String distPath = "dist";
        Path path = Paths.get(distPath);
        
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new RuntimeException("Failed to create dist directory", e);
            }
        }

        // Verify dist directory is writable
        File distDir = new File(distPath);
        if (!distDir.canWrite()) {
            throw new RuntimeException("Dist directory is not writable");
        }

        // Additional config initialization can be added here
    }
}