import org.apache.log4j.spi.LoggingEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerFormatter {

    /**
     * Produce una cadena formateada según lo especificado por el patrón de conversión.
     */
    public String format(LoggingEvent event) {
        StringBuilder formattedString = new StringBuilder();
        
        // Example of formatting: timestamp, log level, logger name, and message
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date(event.getTimeStamp()));
        String level = event.getLevel().toString();
        String loggerName = event.getLoggerName();
        String message = event.getRenderedMessage();
        
        formattedString.append("[").append(timestamp).append("] ")
                       .append("[").append(level).append("] ")
                       .append("[").append(loggerName).append("] ")
                       .append(message);
        
        return formattedString.toString();
    }
}