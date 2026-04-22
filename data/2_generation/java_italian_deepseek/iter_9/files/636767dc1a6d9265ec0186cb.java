import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigManager {

    /**
     * Inizializza la configurazione, ad esempio controlla il percorso di distribuzione.
     */
    public void init() {
        // Controlla se il percorso di distribuzione esiste
        Path distributionPath = Paths.get("path/to/distribution");
        if (Files.exists(distributionPath)) {
            System.out.println("Il percorso di distribuzione esiste: " + distributionPath);
        } else {
            System.out.println("Il percorso di distribuzione non esiste: " + distributionPath);
        }
    }

    public static void main(String[] args) {
        ConfigManager configManager = new ConfigManager();
        configManager.init();
    }
}