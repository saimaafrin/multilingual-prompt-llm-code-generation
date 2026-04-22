import java.util.logging.Logger;

public class LoggerChecker {
    
    /** 
     * Verifica si el registrador nombrado existe en la jerarquía. Si es así, devuelve su referencia; de lo contrario, devuelve <code>null</code>.
     * @param name El nombre del registrador que se busca.
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