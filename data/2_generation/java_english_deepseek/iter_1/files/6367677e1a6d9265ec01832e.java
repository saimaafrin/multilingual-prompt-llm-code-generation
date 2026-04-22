import java.util.logging.Logger;
import java.util.logging.LogManager;

public class LoggerChecker {

    /**
     * Check if the named logger exists in the hierarchy. If so return its reference, otherwise returns <code>null</code>.
     * @param name The name of the logger to search for.
     * @return The Logger object if it exists, otherwise null.
     */
    public Logger exists(String name) {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger(name);
        return logger;
    }
}