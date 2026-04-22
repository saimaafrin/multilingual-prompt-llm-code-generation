import java.io.File;

public class ConfigurationManager {
    /**
     * Crea la directory in cui verrà scritta la lista dei file MRU. La directory "lf5" viene creata 
     * nella directory Documenti e Impostazioni sui computer Windows 2000 e ovunque punti la 
     * variabile user.home su tutte le altre piattaforme.
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        File configDir;
        
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            // Per Windows, crea la directory in "Documents and Settings"
            configDir = new File(userHome + File.separator + 
                               "Documents and Settings" + File.separator + 
                               "lf5");
        } else {
            // Per altri sistemi operativi, crea la directory direttamente in user.home
            configDir = new File(userHome + File.separator + "lf5");
        }

        // Crea la directory se non esiste
        if (!configDir.exists()) {
            boolean created = configDir.mkdirs();
            if (!created) {
                throw new RuntimeException("Impossibile creare la directory di configurazione: " + 
                                        configDir.getAbsolutePath());
            }
        }
    }
}