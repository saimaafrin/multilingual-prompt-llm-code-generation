import org.apache.log4j.spi.LoggingEvent;

public class Logger {

    /**
     * This method does actual writing
     */
    protected void subAppend(LoggingEvent event) {
        // Implementation of the actual writing logic
        // For example, writing the event to a file or console
        System.out.println(event.getMessage());
    }
}