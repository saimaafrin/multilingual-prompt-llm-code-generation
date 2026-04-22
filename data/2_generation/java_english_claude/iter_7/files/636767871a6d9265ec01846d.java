import java.io.File;

public class ConfigurationManager {
    /**
     * Creates the directory where the MRU file list will be written. The "lf5" directory 
     * is created in the Documents and Settings directory on Windows 2000 machines and 
     * where ever the user.home variable points on all other platforms.
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        String fileSeparator = System.getProperty("file.separator");
        String configDirPath = userHome + fileSeparator + "lf5";
        
        File configDir = new File(configDirPath);
        if (!configDir.exists()) {
            configDir.mkdir();
        }
    }
}