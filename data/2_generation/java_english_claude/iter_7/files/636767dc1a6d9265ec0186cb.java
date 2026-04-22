import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class ConfigInitializer {
    private static final Logger logger = Logger.getLogger(ConfigInitializer.class.getName());
    private static final String DIST_PATH = "dist";
    
    /**
     * initialize config, such as check dist path
     */
    public void init() {
        try {
            // Check if dist directory exists
            Path distPath = Paths.get(DIST_PATH);
            if (!Files.exists(distPath)) {
                // Create dist directory if it doesn't exist
                Files.createDirectory(distPath);
                logger.info("Created dist directory at: " + distPath.toAbsolutePath());
            }

            // Verify directory is writable
            if (!Files.isWritable(distPath)) {
                throw new IOException("Dist directory is not writable: " + distPath.toAbsolutePath());
            }

            // Additional initialization can be added here
            
            logger.info("Configuration initialized successfully");
            
        } catch (IOException e) {
            logger.severe("Failed to initialize configuration: " + e.getMessage());
            throw new RuntimeException("Configuration initialization failed", e);
        }
    }
}