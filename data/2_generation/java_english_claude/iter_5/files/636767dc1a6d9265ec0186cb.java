import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class ConfigInitializer {
    private static final Logger logger = Logger.getLogger(ConfigInitializer.class.getName());
    private static final String DIST_PATH = "dist";
    
    public void init() {
        try {
            // Check if dist directory exists, create if not
            Path distPath = Paths.get(DIST_PATH);
            if (!Files.exists(distPath)) {
                Files.createDirectory(distPath);
                logger.info("Created dist directory at: " + distPath.toAbsolutePath());
            }

            // Verify dist directory is writable
            if (!Files.isWritable(distPath)) {
                throw new IOException("Dist directory is not writable: " + distPath.toAbsolutePath());
            }

            // Initialize other config settings as needed
            logger.info("Configuration initialized successfully");
            
        } catch (IOException e) {
            logger.severe("Failed to initialize configuration: " + e.getMessage());
            throw new RuntimeException("Configuration initialization failed", e);
        }
    }
}