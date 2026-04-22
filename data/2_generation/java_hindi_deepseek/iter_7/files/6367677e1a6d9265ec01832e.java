import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerChecker {

    /**
     * जांचें कि क्या नामित लॉगर पदानुक्रम में मौजूद है। यदि हाँ, तो इसका संदर्भ लौटाएँ, अन्यथा <code>null</code> लौटाएँ।
     * @param name उस लॉगर का नाम जिसे खोजा जाना है।
     */
    public Logger exists(String name) {
        try {
            // LogManager.getLogger() will return the logger if it exists, otherwise it will create a new one.
            // To check if the logger exists, we can compare the logger's name with the provided name.
            Logger logger = LogManager.getLogger(name);
            if (logger.getName().equals(name)) {
                return logger;
            } else {
                return null;
            }
        } catch (Exception e) {
            // In case of any exception, return null
            return null;
        }
    }
}