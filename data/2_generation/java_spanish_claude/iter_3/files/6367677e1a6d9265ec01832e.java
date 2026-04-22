import java.util.logging.Logger;

public class LoggerHierarchy {
    
    public Logger exists(String name) {
        try {
            // Attempt to get logger by name, returns null if not found
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