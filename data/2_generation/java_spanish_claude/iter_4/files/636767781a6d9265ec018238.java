import org.apache.log4j.Appender;
import java.util.Enumeration;

public class Logger {
    private AppenderList appenderList;

    /**
     * Devuelve <code>true</code> si el "appender" especificado está en la lista de "appenders" adjuntos, <code>false</code> en caso contrario.
     * @since 1.2
     */
    public boolean isAttached(Appender appender) {
        if (appender == null) {
            return false;
        }

        if (appenderList == null) {
            return false;
        }

        Enumeration<Appender> appenders = appenderList.getAllAppenders();
        if (appenders == null) {
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