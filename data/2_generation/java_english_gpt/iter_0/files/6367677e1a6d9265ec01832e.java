import java.util.logging.Logger;

public class LoggerChecker {
    
    /** 
     * Check if the named logger exists in the hierarchy. If so return its reference, otherwise returns <code>null</code>.
     * @param name The name of the logger to search for.
     */
    public Logger exists(String name) {
        Logger logger = Logger.getLogger(name);
        return logger.getHandlers().length > 0 ? logger : null;
    }

    public static void main(String[] args) {
        LoggerChecker checker = new LoggerChecker();
        Logger logger = checker.exists("myLogger");
        if (logger != null) {
            System.out.println("Logger exists: " + logger.getName());
        } else {
            System.out.println("Logger does not exist.");
        }
    }
}