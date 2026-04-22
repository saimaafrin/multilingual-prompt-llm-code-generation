import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {
    /**
     * Check if the named logger exists in the hierarchy. If so return its reference, otherwise returns <code>null</code>.
     * @param name The name of the logger to search for.
     * @return Logger instance if exists, null otherwise
     */
    public static Logger exists(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }

        try {
            // Get logger context
            org.apache.logging.log4j.spi.LoggerContext context = LogManager.getContext(false);
            
            // Check if logger exists in context
            if (context != null) {
                org.apache.logging.log4j.spi.LoggerConfig loggerConfig = 
                    context.getConfiguration().getLoggerConfig(name);
                
                if (loggerConfig != null && loggerConfig.getName().equals(name)) {
                    return LogManager.getLogger(name);
                }
            }
        } catch (Exception e) {
            // Return null if any error occurs during lookup
            return null;
        }
        
        return null;
    }
}