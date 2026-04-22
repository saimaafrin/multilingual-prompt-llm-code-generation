import org.apache.log4j.spi.LoggingEvent;

public class Logger {
    
    /** 
     * This method does actual writing
     */
    protected void subAppend(LoggingEvent event) {
        if (event != null) {
            // Example of writing the logging event to the console
            System.out.println("Logging Event: " + event.getMessage());
        } else {
            System.out.println("No logging event provided.");
        }
    }
}