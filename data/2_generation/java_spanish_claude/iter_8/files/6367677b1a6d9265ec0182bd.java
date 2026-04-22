import org.apache.log4j.spi.LoggingEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLogFormatter {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss,SSS";
    private static final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    public String format(final LoggingEvent event) {
        StringBuilder sb = new StringBuilder();
        
        // Add timestamp
        Date eventTime = new Date(event.getTimeStamp());
        sb.append(sdf.format(eventTime));
        sb.append(" ");
        
        // Add log level
        sb.append("[").append(event.getLevel().toString()).append("] ");
        
        // Add logger name
        sb.append(event.getLoggerName());
        sb.append(" - ");
        
        // Add message
        sb.append(event.getRenderedMessage());
        
        // Add throwable if exists
        String[] throwableInfo = event.getThrowableStrRep();
        if (throwableInfo != null) {
            sb.append("\n");
            for (String throwableLine : throwableInfo) {
                sb.append(throwableLine).append("\n");
            }
        }
        
        return sb.toString();
    }
}