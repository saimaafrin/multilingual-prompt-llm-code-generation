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
                    .getClassLoader()
                    .getResources("")
                    .getClass()
                    .getDeclaredFields()[0]
                    .get(null);
                    
            for (Logger logger : loggers) {
                if (name.equals(logger.getName())) {
                    return logger;
                }
            }
        } catch (Exception e) {
            // Return null if any error occurs during lookup
            return null;
        }
        
        return null;
    }
}