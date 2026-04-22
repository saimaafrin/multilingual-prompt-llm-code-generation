import org.apache.log4j.Appender;
import java.util.Enumeration;

public class AppenderManager {
    
    private Vector<Appender> appenders;
    
    public boolean isAttached(Appender appender) {
        if (appender == null || appenders == null) {
            return false;
        }
        
        Enumeration<Appender> existingAppenders = appenders.elements();
        while (existingAppenders.hasMoreElements()) {
            Appender current = existingAppenders.nextElement();
            if (current.equals(appender)) {
                return true;
            }
        }
        return false;
    }
}