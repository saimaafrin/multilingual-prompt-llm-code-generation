import java.io.File;

public class ConfigurationDirectoryCreator {

    /**
     * Crea la directory in cui verrà scritta la lista dei file MRU. La directory "lf5" viene creata nella directory Documenti e Impostazioni sui computer Windows 2000 e ovunque punti la variabile user.home su tutte le altre piattaforme.
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        String directoryName = "lf5";
        File configDir;

        // Check if the OS is Windows 2000
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows") && osName.contains("2000")) {
            configDir = new File(userHome + "\\Documenti e Impostazioni\\" + directoryName);
        } else {
            configDir = new File(userHome + File.separator + directoryName);
        }

        // Create the directory if it doesn't exist
        if (!configDir.exists()) {
            boolean created = configDir.mkdirs();
            if (created) {
                System.out.println("Directory created: " + configDir.getAbsolutePath());
            } else {
                System.out.println("Failed to create directory: " + configDir.getAbsolutePath());
            }
        } else {
            System.out.println("Directory already exists: " + configDir.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}