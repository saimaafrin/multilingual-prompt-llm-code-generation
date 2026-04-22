import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerChecker {

    /**
     * Check if the named logger exists in the hierarchy. If so return its reference, otherwise returns <code>null</code>.
     * @param name The name of the logger to search for.
     * @return The logger if it exists, otherwise <code>null</code>.
     */
    public Logger exists(String name) {
        Logger logger = LogManager.getLogger(name);
        if (logger != null && logger.getName().equals(name)) {
            return logger;
        } else {
            return null;
        }
    }
}