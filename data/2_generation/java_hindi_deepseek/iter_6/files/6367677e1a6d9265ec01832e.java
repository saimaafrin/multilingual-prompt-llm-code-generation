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
            // LogManager.getLogger() may throw an exception if the logger is not found
            // or if there are other issues. We catch it here and return null.
        }
        return null;
    }
}