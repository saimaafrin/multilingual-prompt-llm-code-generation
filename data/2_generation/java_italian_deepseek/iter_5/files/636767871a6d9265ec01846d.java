import java.io.File;

public class ConfigurationDirectoryCreator {

    /**
     * Crea la directory in cui verrà scritta la lista dei file MRU. La directory "lf5" viene creata nella directory Documenti e Impostazioni sui computer Windows 2000 e ovunque punti la variabile user.home su tutte le altre piattaforme.
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        String osName = System.getProperty("os.name").toLowerCase();

        String configDirPath;
        if (osName.contains("windows 2000")) {
            configDirPath = userHome + "\\Documenti e Impostazioni\\lf5";
        } else {
            configDirPath = userHome + File.separator + "lf5";
        }

        File configDir = new File(configDirPath);
        if (!configDir.exists()) {
            boolean created = configDir.mkdirs();
            if (created) {
                System.out.println("Directory creata con successo: " + configDirPath);
            } else {
                System.out.println("Impossibile creare la directory: " + configDirPath);
            }
        } else {
            System.out.println("La directory esiste già: " + configDirPath);
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}