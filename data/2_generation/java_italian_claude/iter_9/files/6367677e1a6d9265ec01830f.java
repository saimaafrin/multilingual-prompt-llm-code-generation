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
        formattedMessage.append(dateFormat.format(new Date(event.getTimeStamp())));
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
        
        // Add throwable if exists
        String[] throwableStrRep = event.getThrowableStrRep();
        if (throwableStrRep != null) {
            formattedMessage.append("\n");
            for (String throwableLine : throwableStrRep) {
                formattedMessage.append(throwableLine);
                formattedMessage.append("\n");
            }
        }
        
        return formattedMessage.toString();
    }
}