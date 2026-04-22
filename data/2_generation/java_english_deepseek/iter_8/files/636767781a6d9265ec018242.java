import org.apache.log4j.Appender;
import org.apache.log4j.spi.LoggingEvent;

public class Logger {
    private Appender[] appenders;

    public Logger(Appender[] appenders) {
        this.appenders = appenders;
    }

    /**
     * Call the <code>doAppend</code> method on all attached appenders.
     * @param event The logging event to append.
     * @return The number of appenders that successfully appended the event.
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int count = 0;
        if (appenders != null) {
            for (Appender appender : appenders) {
                try {
                    appender.doAppend(event);
                    count++;
                } catch (Exception e) {
                    // Log the exception or handle it as needed
                    System.err.println("Error appending event to appender: " + e.getMessage());
                }
            }
        }
        return count;
    }
}