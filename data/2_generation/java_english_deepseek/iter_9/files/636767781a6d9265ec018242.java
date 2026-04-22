import org.apache.log4j.Appender;
import org.apache.log4j.spi.LoggingEvent;

public class Logger {
    private Appender[] appenders;

    public Logger(Appender[] appenders) {
        this.appenders = appenders;
    }

    /**
     * Call the <code>doAppend</code> method on all attached appenders.
     * @param event The LoggingEvent to be appended.
     * @return The number of appenders that successfully appended the event.
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int count = 0;
        if (appenders != null) {
            for (Appender appender : appenders) {
                if (appender != null) {
                    try {
                        appender.doAppend(event);
                        count++;
                    } catch (Exception e) {
                        // Handle or log the exception if necessary
                        System.err.println("Error appending event: " + e.getMessage());
                    }
                }
            }
        }
        return count;
    }
}