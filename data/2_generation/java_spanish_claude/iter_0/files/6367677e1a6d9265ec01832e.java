import java.util.logging.Logger;

public class LoggerManager {
    
    /**
     * Verifica si el registrador nombrado existe en la jerarquía. Si es así, devuelve su referencia; de lo contrario, devuelve <code>null</code>.
     * @param name El nombre del registrador que se busca.
     */
    public Logger exists(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        
        try {
            // Get the logger if it exists, without creating a new one
            Logger logger = Logger.getLogger(name);
            
            // Check if logger exists by verifying it has handlers or parent
            if (logger.getHandlers().length > 0 || logger.getParent() != null) {
                return logger;
            }
            
            return null;
            
        } catch (SecurityException e) {
            return null;
        }
    }
}