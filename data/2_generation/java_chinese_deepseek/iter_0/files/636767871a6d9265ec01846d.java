import java.io.File;
import java.nio.file.Paths;

public class MRUDirectoryCreator {

    public static void createConfigurationDirectory() {
        String osName = System.getProperty("os.name").toLowerCase();
        String userHome = System.getProperty("user.home");
        String configDirPath;

        if (osName.contains("windows") && osName.contains("2000")) {
            // For Windows 2000, create the directory in "Documents and Settings"
            configDirPath = Paths.get(userHome, "Documents and Settings", "lf5").toString();
        } else {
            // For other platforms, create the directory in user.home
            configDirPath = Paths.get(userHome, "lf5").toString();
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

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}