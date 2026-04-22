import org.apache.log4j.Appender;
import org.apache.log4j.spi.LoggingEvent;

public class Logger {
    private Appender[] appenders;

    public Logger(Appender[] appenders) {
        this.appenders = appenders;
    }

    /**
     * Call the <code>doAppend</code> method on all attached appenders.
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int count = 0;
        if (appenders != null) {
            for (Appender appender : appenders) {
                if (appender != null) {
                    appender.doAppend(event);
                    count++;
                }
            }
        }
        return count;
    }
}