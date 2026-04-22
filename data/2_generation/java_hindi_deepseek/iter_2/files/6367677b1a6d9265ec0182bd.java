import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * एक लॉगिंग इवेंट को एक लेखक के लिए प्रारूपित करता है।
     * @param event प्रारूपित करने के लिए लॉगिंग इवेंट।
     * @return प्रारूपित स्ट्रिंग।
     */
    public String format(final LoggingEvent event) {
        StringBuilder formattedMessage = new StringBuilder();
        
        // Add timestamp
        formattedMessage.append("[").append(event.getTimeStamp()).append("] ");
        
        // Add log level
        formattedMessage.append("[").append(event.getLevel().toString()).append("] ");
        
        // Add logger name
        formattedMessage.append("[").append(event.getLoggerName()).append("] ");
        
        // Add message
        formattedMessage.append(event.getRenderedMessage());
        
        return formattedMessage.toString();
    }
}