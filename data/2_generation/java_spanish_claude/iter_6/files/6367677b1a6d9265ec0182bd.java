import org.apache.log4j.spi.LoggingEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLogFormatter {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss,SSS";
    private static final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    /** 
     * Formatea un evento de "logging" para un "writer".
     * @param event evento de "logging" que se va a formatear.
     */
    public String format(final LoggingEvent event) {
        if (event == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        
        // Add timestamp
        Date eventDate = new Date(event.getTimeStamp());
        sb.append(sdf.format(eventDate));
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
            for (String throwableLine : throwableStrRep) {
                sb.append(throwableLine).append("\n");
            }
        }
        
        // Add new line at the end
        sb.append("\n");
        
        return sb.toString();
    }
}