import java.util.logging.Logger;

public class LoggerChecker {
    
    /**
     * जांचें कि क्या नामित लॉगर पदानुक्रम में मौजूद है। यदि हाँ, तो इसका संदर्भ लौटाएँ, अन्यथा <code>null</code> लौटाएँ।
     * @param name उस लॉगर का नाम जिसे खोजा जाना है।
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