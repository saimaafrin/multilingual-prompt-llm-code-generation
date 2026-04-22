import org.apache.log4j.spi.LoggingEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLogFormatter {
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
    
    /**
     * Formatea un evento de "logging" para un "writer".
     * @param event evento de "logging" que se va a formatear.
     */
    public String format(final LoggingEvent event) {
        StringBuilder sb = new StringBuilder();
        
        // Add timestamp
        Date timestamp = new Date(event.getTimeStamp());
        sb.append(DATE_FORMAT.format(timestamp));
        sb.append(" ");
        
        // Add log level
        sb.append("[").append(event.getLevel().toString()).append("] ");
        
        // Add logger name
        sb.append(event.getLoggerName());
        sb.append(" - ");
        
        // Add message
        sb.append(event.getRenderedMessage());
        
        // Add throwable if exists
        String[] throwableStrRep = event.getThrowableStrRep();
        if (throwableStrRep != null) {
            sb.append("\n");
            for (String line : throwableStrRep) {
                sb.append(line).append("\n");
            }
        }
        
        // Add new line
        sb.append("\n");
        
        return sb.toString();
    }
}