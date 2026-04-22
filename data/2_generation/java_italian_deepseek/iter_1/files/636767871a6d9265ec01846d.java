import java.io.File;

public class ConfigurationDirectoryCreator {

    /**
     * Crea la directory in cui verrà scritta la lista dei file MRU. La directory "lf5" viene creata nella directory Documenti e Impostazioni sui computer Windows 2000 e ovunque punti la variabile user.home su tutte le altre piattaforme.
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        String directoryPath;

        // Verifica se il sistema operativo è Windows 2000
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows") && osName.contains("2000")) {
            directoryPath = userHome + "\\Documenti e Impostazioni\\lf5";
        } else {
            directoryPath = userHome + File.separator + "lf5";
        }

        File directory = new File(directoryPath);
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