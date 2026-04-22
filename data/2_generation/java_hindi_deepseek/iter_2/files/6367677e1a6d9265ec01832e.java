import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerChecker {

    /**
     * जांचें कि क्या नामित लॉगर पदानुक्रम में मौजूद है। यदि हाँ, तो इसका संदर्भ लौटाएँ, अन्यथा <code>null</code> लौटाएँ।
     * @param name उस लॉगर का नाम जिसे खोजा जाना है।
     * @return लॉगर का संदर्भ यदि मौजूद है, अन्यथा <code>null</code>।
     */
    public Logger exists(String name) {
        try {
            Logger logger = LogManager.getLogger(name);
            if (logger != null) {
                return logger;
            }
        } catch (Exception e) {
            // LogManager.getLogger() may throw an exception if the logger does not exist
            // or if there is an issue with the logger configuration.
            // We can ignore this exception and return null.
        }
        return null;
    }
}