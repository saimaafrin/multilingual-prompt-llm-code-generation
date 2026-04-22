import java.io.File;

public class MRUConfig {
    /**
     * Creates the directory where the MRU file list will be written. The "lf5" directory is created in the Documents and Settings directory on Windows 2000 machines and where ever the user.home variable points on all other platforms.
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        String osName = System.getProperty("os.name").toLowerCase();
        
        String configDirPath;
        if (osName.contains("windows 2000")) {
            configDirPath = System.getenv("USERPROFILE") + File.separator + "Documents and Settings" + File.separator + "lf5";
        } else {
            configDirPath = userHome + File.separator + "lf5";
        }

        File configDir = new File(configDirPath);
        if (!configDir.exists()) {
            boolean created = configDir.mkdirs();
            if (created) {
                System.out.println("Configuration directory created at: " + configDirPath);
            } else {
                System.out.println("Failed to create configuration directory at: " + configDirPath);
            }
        } else {
            System.out.println("Configuration directory already exists at: " + configDirPath);
        }
    }
}