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
        formattedMessage.append("Timestamp: ").append(event.getTimeStamp()).append("\n");
        
        // Add log level
        formattedMessage.append("Level: ").append(event.getLevel().toString()).append("\n");
        
        // Add logger name
        formattedMessage.append("Logger: ").append(event.getLoggerName()).append("\n");
        
        // Add message
        formattedMessage.append("Message: ").append(event.getRenderedMessage()).append("\n");
        
        // Add throwable information if present
        if (event.getThrowableInformation() != null) {
            formattedMessage.append("Exception: ").append(event.getThrowableInformation().getThrowable().toString()).append("\n");
        }
        
        return formattedMessage.toString();
    }
}