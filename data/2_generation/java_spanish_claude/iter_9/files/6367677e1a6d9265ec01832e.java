import java.util.logging.Logger;

public class LoggerHierarchy {
    
    public Logger exists(String name) {
        try {
            // Attempt to get logger by name without creating it
            Logger logger = Logger.getLogger(name);
            
            // Check if logger already exists in hierarchy
            if (logger.getParent() != null) {
                return logger;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}