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
                deployDir.mkdirs();
                LOGGER.info("Created default deployment directory: " + DEFAULT_DEPLOY_PATH);
            }
            
            if (!deployDir.canWrite()) {
                LOGGER.warning("Deploy directory is not writable: " + DEFAULT_DEPLOY_PATH);
                throw new IOException("Deploy directory is not writable");
            }
            
            this.deployPath = DEFAULT_DEPLOY_PATH;
            LOGGER.info("Configuration initialized successfully");
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Failed to initialize configuration", e);
            throw new RuntimeException("Configuration initialization failed", e);
        }
    }
}