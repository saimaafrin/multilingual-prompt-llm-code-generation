import org.apache.log4j.spi.LoggingEvent;

public class Logger {
    
    /**
     * This method does actual writing
     */
    protected void subAppend(LoggingEvent event) {
        // Example implementation: write the logging event to the console
        System.out.println(event.getRenderedMessage());
    }
}