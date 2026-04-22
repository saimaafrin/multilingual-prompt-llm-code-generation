import org.apache.log4j.Appender;
import org.apache.log4j.spi.LoggingEvent;
import java.util.Enumeration;

public class Logger {
    private Enumeration<Appender> appenders;

    public Logger(Enumeration<Appender> appenders) {
        this.appenders = appenders;
    }

    public int appendLoopOnAppenders(LoggingEvent event) {
        int count = 0;
        if (appenders != null) {
            while (appenders.hasMoreElements()) {
                Appender appender = appenders.nextElement();
                appender.doAppend(event);
                count++;
            }
        }
        return count;
    }
}