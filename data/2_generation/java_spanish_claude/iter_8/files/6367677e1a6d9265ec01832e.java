import java.util.logging.Logger;

public class LoggerHierarchy {
    
    public Logger exists(String name) {
        try {
            // Attempt to get logger by name without creating it
            Logger logger = Logger.getLogger(name);
            
            // Check if logger exists by getting parent
            // If parent is null and name isn't empty/root logger, 
            // then logger doesn't exist
            if (logger.getParent() == null && !name.isEmpty()) {
                return null;
            }
            
            return logger;
            
        } catch (IllegalArgumentException e) {
            // Return null if name is invalid
            return null;
        }
    }
}