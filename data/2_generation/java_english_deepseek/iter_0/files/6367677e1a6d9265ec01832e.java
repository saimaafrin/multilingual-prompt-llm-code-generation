import java.util.logging.Logger;

public class LoggerChecker {

    /**
     * Check if the named logger exists in the hierarchy. If so return its reference, otherwise returns <code>null</code>.
     * @param name The name of the logger to search for.
     * @return The Logger instance if it exists, otherwise null.
     */
    public Logger exists(String name) {
        Logger logger = Logger.getLogger(name);
        if (logger != null) {
            return logger;
        } else {
            return null;
        }
    }
}