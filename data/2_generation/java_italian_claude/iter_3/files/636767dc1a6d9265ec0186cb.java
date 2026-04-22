import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ConfigurationManager {
    private static final Logger LOGGER = Logger.getLogger(ConfigurationManager.class.getName());
    private static final String DEFAULT_DEPLOY_PATH = "/opt/deploy";
    private String deployPath;

    /**
     * inizializza la configurazione, ad esempio controlla il percorso di distribuzione
     */
    public void init() {
        try {
            // Check if default deploy path exists
            File deployDir = new File(DEFAULT_DEPLOY_PATH);
            
            if (!deployDir.exists()) {
                boolean created = deployDir.mkdirs();
                if (created) {
                    LOGGER.info("Created default deployment directory: " + DEFAULT_DEPLOY_PATH);
                } else {
                    LOGGER.warning("Failed to create deployment directory");
                }
            }

            // Verify directory is writable
            if (deployDir.canWrite()) {
                this.deployPath = DEFAULT_DEPLOY_PATH;
                LOGGER.info("Deployment path initialized to: " + this.deployPath);
            } else {
                LOGGER.severe("Deployment directory is not writable");
                throw new IOException("Deployment directory is not writable");
            }

        } catch (SecurityException e) {
            LOGGER.log(Level.SEVERE, "Security exception while initializing configuration", e);
            throw new RuntimeException("Failed to initialize configuration", e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "IO exception while initializing configuration", e);
            throw new RuntimeException("Failed to initialize configuration", e);
        }
    }
}