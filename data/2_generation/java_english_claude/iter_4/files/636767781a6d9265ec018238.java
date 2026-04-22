import org.apache.log4j.Appender;
import java.util.Enumeration;

public class Logger {
    private AppenderList appenderList;

    public boolean isAttached(Appender appender) {
        if (appender == null) {
            return false;
        }

        // Get enumeration of all attached appenders
        Enumeration<Appender> appenders = getAllAppenders();
        
        // If no appenders, return false
        if (appenders == null) {
            return false;
        }

        // Check each appender
        while (appenders.hasMoreElements()) {
            Appender currentAppender = appenders.nextElement();
            if (currentAppender == appender) {
                return true;
            }
        }

        return false;
    }

    // Helper method to get appenders
    public Enumeration<Appender> getAllAppenders() {
        return appenderList.getAllAppenders();
    }
}