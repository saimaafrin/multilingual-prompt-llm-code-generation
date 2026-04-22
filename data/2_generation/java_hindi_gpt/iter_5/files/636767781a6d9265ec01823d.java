import org.apache.log4j.spi.LoggingEvent;

public class Logger {
    
    /**
     * यह विधि वास्तविक लेखन करती है
     */
    protected void subAppend(LoggingEvent event) {
        if (event != null) {
            // यहाँ लॉगिंग इवेंट को संभालने का कोड लिखें
            System.out.println("Logging event: " + event.getMessage());
        } else {
            System.out.println("No event to log.");
        }
    }
}