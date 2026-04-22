import org.apache.log4j.spi.LoggingEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomFormatter {
    
    /**
     * Produce una stringa formattata come specificato dal modello di conversione.
     */
    public String format(LoggingEvent event) {
        if (event == null) {
            return "";
        }

        StringBuilder formattedMessage = new StringBuilder();
        
        // Add timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        String timestamp = dateFormat.format(new Date(event.getTimeStamp()));
        formattedMessage.append(timestamp);
        formattedMessage.append(" ");
        
        // Add log level
        formattedMessage.append("[");
        formattedMessage.append(event.getLevel().toString());
        formattedMessage.append("] ");
        
        // Add logger name
        formattedMessage.append(event.getLoggerName());
        formattedMessage.append(" - ");
        
        // Add message
        formattedMessage.append(event.getRenderedMessage());
        
        // Add throwable info if exists
        String[] throwableInfo = event.getThrowableStrRep();
        if (throwableInfo != null) {
            formattedMessage.append("\n");
            for (String line : throwableInfo) {
                formattedMessage.append(line);
                formattedMessage.append("\n");
            }
        }
        
        return formattedMessage.toString();
    }
}