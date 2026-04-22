import org.apache.log4j.spi.LoggingEvent;

public class LoggerFormatter {
    /** 
     * एक लॉगिंग इवेंट को एक लेखक के लिए प्रारूपित करता है।
     * @param event प्रारूपित करने के लिए लॉगिंग इवेंट।
     */
    public String format(final LoggingEvent event) {
        StringBuilder formattedLog = new StringBuilder();
        formattedLog.append("Timestamp: ").append(event.getTimeStamp()).append("\n");
        formattedLog.append("Level: ").append(event.getLevel()).append("\n");
        formattedLog.append("Logger: ").append(event.getLoggerName()).append("\n");
        formattedLog.append("Message: ").append(event.getRenderedMessage()).append("\n");
        formattedLog.append("Thread: ").append(event.getThreadName()).append("\n");
        
        return formattedLog.toString();
    }
}