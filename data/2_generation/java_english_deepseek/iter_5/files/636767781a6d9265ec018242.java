import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.Appender;

public class Logger {
    private Appender[] appenders;

    public Logger(Appender[] appenders) {
        this.appenders = appenders;
    }

    /**
     * Call the <code>doAppend</code> method on all attached appenders.
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        if (appenders == null) {
            return 0;
        }

        int count = 0;
        for (Appender appender : appenders) {
            if (appender != null) {
                appender.doAppend(event);
                count++;
            }
        }
        return count;
    }
}