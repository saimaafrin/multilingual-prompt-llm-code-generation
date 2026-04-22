import java.io.File;
import java.io.IOException;

public class ConfigurationDirectoryCreator {

    /** 
     * Creates the directory where the MRU file list will be written. The "lf5" directory is created in the Documents and Settings directory on Windows 2000 machines and where ever the user.home variable points on all other platforms.
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        String directoryPath = userHome + File.separator + "lf5";
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Configuration directory created at: " + directoryPath);
            } else {
                System.err.println("Failed to create configuration directory at: " + directoryPath);
            }
        } else {
            System.out.println("Configuration directory already exists at: " + directoryPath);
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}