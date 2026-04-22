import org.apache.log4j.spi.LoggingEvent;

public class CustomAppender {

    /**
     * यह विधि वास्तविक लेखन करती है
     */
    protected void subAppend(LoggingEvent event) {
        if (event != null) {
            // यहाँ पर लॉगिंग इवेंट को संभालने का कोड लिखें
            System.out.println("Logging Event: " + event.getMessage());
        } else {
            System.out.println("Logging event is null.");
        }
    }
}