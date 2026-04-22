import java.io.File;

public class ConfigurationManager {
    
    /**
     * Creates the directory where the MRU file list will be written. The "lf5" directory is created 
     * in the Documents and Settings directory on Windows 2000 machines and where ever the user.home 
     * variable points on all other platforms.
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        File configDir;
        
        if (System.getProperty("os.name").startsWith("Windows")) {
            // For Windows systems
            configDir = new File(userHome + File.separator + "Documents and Settings" + 
                               File.separator + "lf5");
        } else {
            // For all other operating systems
            configDir = new File(userHome + File.separator + "lf5");
        }

        // Create directory if it doesn't exist
        if (!configDir.exists()) {
            boolean created = configDir.mkdirs();
            if (!created) {
                throw new RuntimeException("Failed to create configuration directory at: " + 
                                         configDir.getAbsolutePath());
            }
        }
    }
}