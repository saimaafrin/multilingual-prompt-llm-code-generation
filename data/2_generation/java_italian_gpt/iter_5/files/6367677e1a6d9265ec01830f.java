import org.apache.log4j.spi.LoggingEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerFormatter {

    /** 
     * Produce una stringa formattata come specificato dal modello di conversione.
     */
    public String format(LoggingEvent event) {
        StringBuilder formattedString = new StringBuilder();
        
        // Get the timestamp of the logging event
        long timestamp = event.getTimeStamp();
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
        
        // Get the log level
        String level = event.getLevel().toString();
        
        // Get the logger name
        String loggerName = event.getLoggerName();
        
        // Get the message
        String message = event.getRenderedMessage();
        
        // Format the string
        formattedString.append(date)
                       .append(" [")
                       .append(level)
                       .append("] ")
                       .append(loggerName)
                       .append(": ")
                       .append(message);
        
        return formattedString.toString();
    }
}