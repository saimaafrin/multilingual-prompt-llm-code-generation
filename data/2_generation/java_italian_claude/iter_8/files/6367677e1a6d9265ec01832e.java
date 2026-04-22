import java.util.logging.Logger;

public class LoggerManager {
    
    /**
     * Controlla se il logger con il nome specificato esiste nella gerarchia. 
     * Se sì, restituisce il suo riferimento, altrimenti restituisce <code>null</code>.
     * @param name Il nome del logger da cercare.
     */
    public Logger exists(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }
        
        // Get the logger if it exists, without creating a new one
        return Logger.getLogger(name).getParent().getLogger(name);
    }
}