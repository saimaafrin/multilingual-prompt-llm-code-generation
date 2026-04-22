public class ConfigurationInitializer {

    /**
     * inizializza la configurazione, ad esempio controlla il percorso di distribuzione
     */
    public void init() {
        String distributionPath = System.getenv("DISTRIBUTION_PATH");
        
        if (distributionPath == null || distributionPath.isEmpty()) {
            throw new IllegalArgumentException("Il percorso di distribuzione non è stato impostato.");
        }
        
        // Ulteriori logiche di inizializzazione possono essere aggiunte qui
        System.out.println("Configurazione inizializzata con successo. Percorso di distribuzione: " + distributionPath);
    }

    public static void main(String[] args) {
        ConfigurationInitializer initializer = new ConfigurationInitializer();
        initializer.init();
    }
}