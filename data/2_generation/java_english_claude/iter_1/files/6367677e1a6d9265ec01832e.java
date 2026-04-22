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
            Logger[] loggers = Logger.getLogger("").getHandlers()
                    .clone()
                    .getClass()
                    .getDeclaredField("loggers")
                    .get(null);
                    
            for (Logger logger : loggers) {
                if (logger != null && name.equals(logger.getName())) {
                    return logger;
                }
            }
        } catch (Exception e) {
            // If any error occurs during lookup, return null
            return null;
        }
        
        return null;
    }
}