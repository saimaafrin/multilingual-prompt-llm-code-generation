import java.io.File;

public class ConfigurationDirectoryCreator {

    /**
     * Crea la directory in cui verrà scritta la lista dei file MRU. La directory "lf5" viene creata nella directory Documenti e Impostazioni sui computer Windows 2000 e ovunque punti la variabile user.home su tutte le altre piattaforme.
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        String directoryPath;

        // Verifica se il sistema operativo è Windows 2000
        if (System.getProperty("os.name").toLowerCase().contains("windows 2000")) {
            directoryPath = userHome + "\\Documenti e Impostazioni\\lf5";
        } else {
            directoryPath = userHome + "\\lf5";
        }

        File directory = new File(directoryPath);

        // Crea la directory se non esiste già
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Directory creata con successo: " + directoryPath);
            } else {
                System.out.println("Impossibile creare la directory: " + directoryPath);
            }
        } else {
            System.out.println("La directory esiste già: " + directoryPath);
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}