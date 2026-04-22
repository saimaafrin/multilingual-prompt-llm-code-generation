import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerChecker {

    /**
     * जांचें कि क्या नामित लॉगर पदानुक्रम में मौजूद है। यदि हाँ, तो इसका संदर्भ लौटाएँ, अन्यथा <code>null</code> लौटाएँ।
     * @param name उस लॉगर का नाम जिसे खोजा जाना है।
     */
    public Logger exists(String name) {
        Logger logger = LogManager.getLogger(name);
        if (logger != null) {
            return logger;
        } else {
            return null;
        }
    }
}