import org.apache.log4j.spi.LoggingEvent;

public class Logger {
    
    /**
     * यह विधि वास्तविक लेखन करती है
     */
    protected void subAppend(LoggingEvent event) {
        // यहाँ पर लॉगिंग इवेंट को संभालने का कोड लिखें
        if (event != null) {
            System.out.println("Logging Event: " + event.getMessage());
        } else {
            System.out.println("No event to log.");
        }
    }
}