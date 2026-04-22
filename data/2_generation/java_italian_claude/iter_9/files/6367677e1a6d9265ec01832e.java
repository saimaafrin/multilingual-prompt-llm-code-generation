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
        LogManager logManager = LogManager.getLogManager();
        Enumeration<String> loggerNames = logManager.getLoggerNames();
        
        // Search through existing loggers
        while (loggerNames.hasMoreElements()) {
            String loggerName = loggerNames.nextElement();
            if (loggerName.equals(name)) {
                return logManager.getLogger(name);
            }
        }
        
        return null;
    }
}