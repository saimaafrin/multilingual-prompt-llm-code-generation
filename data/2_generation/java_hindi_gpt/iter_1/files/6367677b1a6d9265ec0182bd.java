import org.apache.log4j.spi.LoggingEvent;

public class LoggerFormatter {
    /**
     * एक लॉगिंग इवेंट को एक लेखक के लिए प्रारूपित करता है।
     * @param event प्रारूपित करने के लिए लॉगिंग इवेंट।
     * @return प्रारूपित लॉगिंग इवेंट का स्ट्रिंग प्रतिनिधित्व।
     */
    public String format(final LoggingEvent event) {
        StringBuilder formattedEvent = new StringBuilder();
        formattedEvent.append("Timestamp: ").append(event.getTimeStamp()).append("\n");
        formattedEvent.append("Level: ").append(event.getLevel()).append("\n");
        formattedEvent.append("Logger: ").append(event.getLoggerName()).append("\n");
        formattedEvent.append("Message: ").append(event.getRenderedMessage()).append("\n");
        formattedEvent.append("Thread: ").append(event.getThreadName()).append("\n");
        
        return formattedEvent.toString();
    }
}