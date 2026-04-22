public class ConfigurationInitializer {

    /**
     * inizializza la configurazione, ad esempio controlla il percorso di distribuzione
     */
    public void init() {
        String distributionPath = System.getProperty("distribution.path");
        
        if (distributionPath == null || distributionPath.isEmpty()) {
            throw new IllegalArgumentException("Il percorso di distribuzione non è stato impostato.");
        }
        
        // Logica per inizializzare la configurazione
        System.out.println("Inizializzazione della configurazione con il percorso di distribuzione: " + distributionPath);
        
        // Ulteriori controlli e inizializzazioni possono essere aggiunti qui
    }

    public static void main(String[] args) {
        ConfigurationInitializer initializer = new ConfigurationInitializer();
        initializer.init();
    }
}