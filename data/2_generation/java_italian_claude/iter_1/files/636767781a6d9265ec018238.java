import org.apache.log4j.Appender;
import java.util.Enumeration;

public class AppenderManager {
    private Vector appenderList;

    public boolean isAttached(Appender appender) {
        if (appender == null) {
            return false;
        }

        if (appenderList == null) {
            return false;
        }

        Enumeration enumeration = appenderList.elements();
        while (enumeration.hasMoreElements()) {
            Appender currentAppender = (Appender) enumeration.nextElement();
            if (currentAppender.equals(appender)) {
                return true;
            }
        }
        return false;
    }
}