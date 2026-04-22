import java.io.File;

public class ConfigurationManager {
    /**
     * Crea la directory in cui verrà scritta la lista dei file MRU. La directory "lf5" viene creata 
     * nella directory Documenti e Impostazioni sui computer Windows 2000 e ovunque punti la 
     * variabile user.home su tutte le altre piattaforme.
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        String configDirPath;
        
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            configDirPath = userHome + File.separator + "Documenti e Impostazioni" + 
                           File.separator + "lf5";
        } else {
            configDirPath = userHome + File.separator + "lf5";
        }

        File configDir = new File(configDirPath);
        
        if (!configDir.exists()) {
            boolean created = configDir.mkdirs();
            if (!created) {
                throw new RuntimeException("Impossibile creare la directory di configurazione: " + 
                                         configDirPath);
            }
        }
    }
}