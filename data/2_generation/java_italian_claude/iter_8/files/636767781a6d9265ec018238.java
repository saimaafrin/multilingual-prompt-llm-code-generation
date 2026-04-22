import org.apache.log4j.Appender;
import java.util.Enumeration;

public class AppenderManager {
    private Enumeration<Appender> appenders;

    /**
     * Restituisce <code>true</code> se l'appender specificato è presente nell'elenco degli appender allegati, <code>false</code> altrimenti.
     * @since 1.2
     */
    public boolean isAttached(Appender appender) {
        if (appender == null) {
            return false;
        }

        while (appenders.hasMoreElements()) {
            Appender currentAppender = appenders.nextElement();
            if (currentAppender == appender) {
                return true;
            }
        }
        return false;
    }
}