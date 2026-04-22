import org.apache.log4j.spi.LoggingEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerFormatter {

    /**
     * Produce una cadena formateada según lo especificado por el patrón de conversión.
     */
    public String format(LoggingEvent event) {
        StringBuilder formattedMessage = new StringBuilder();
        
        // Get the timestamp of the logging event
        long timestamp = event.getTimeStamp();
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
        
        // Get the log level
        String level = event.getLevel().toString();
        
        // Get the logger name
        String loggerName = event.getLoggerName();
        
        // Get the message
        String message = event.getRenderedMessage();
        
        // Format the message
        formattedMessage.append(date)
                        .append(" [")
                        .append(level)
                        .append("] ")
                        .append(loggerName)
                        .append(": ")
                        .append(message);
        
        return formattedMessage.toString();
    }
}