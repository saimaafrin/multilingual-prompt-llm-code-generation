import java.util.logging.Logger;

public class LoggerUtils {
    
    /**
     * Controlla se il logger con il nome specificato esiste nella gerarchia. 
     * Se sì, restituisce il suo riferimento, altrimenti restituisce <code>null</code>.
     * @param name Il nome del logger da cercare.
     */
    public Logger exists(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }
        
        // Get the logger manager's logger list
        Logger rootLogger = Logger.getLogger("");
        Logger logger = rootLogger;
        
        // Try to find existing logger with exact name match
        while (logger != null) {
            if (logger.getName().equals(name)) {
                return logger;
            }
            logger = logger.getParent();
        }
        
        // Check if logger exists in LogManager
        try {
            Logger existingLogger = Logger.getLogger(name);
            // If logger was just created, return null
            if (existingLogger.getHandlers().length == 0 && 
                existingLogger.getParent() == rootLogger) {
                return null;
            }
            return existingLogger;
        } catch (Exception e) {
            return null;
        }
    }
}