import java.util.logging.Logger;

public class LoggerManager {

    /**
     * Check if the named logger exists in the hierarchy. If so return its reference, otherwise returns <code>null</code>.
     * @param name The name of the logger to search for.
     */
    public Logger exists(String name) {
        if (name == null) {
            return null;
        }
        
        try {
            // Get the logger if it exists, without creating a new one
            Logger logger = Logger.getLogger(name);
            
            // Check if logger exists by seeing if it has any handlers or parent
            if (logger.getHandlers().length > 0 || logger.getParent() != null) {
                return logger;
            }
            
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}