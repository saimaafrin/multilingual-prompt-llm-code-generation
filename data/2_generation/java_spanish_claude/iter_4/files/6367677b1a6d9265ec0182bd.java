import org.apache.log4j.spi.LoggingEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLogFormatter {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
    
    public String format(final LoggingEvent event) {
        if (event == null) {
            return "";
        }

        StringBuilder formattedLog = new StringBuilder();
        
        // Add timestamp
        formattedLog.append(DATE_FORMAT.format(new Date(event.getTimeStamp())));
        formattedLog.append(" ");
        
        // Add log level
        formattedLog.append("[").append(event.getLevel().toString()).append("] ");
        
        // Add logger name
        formattedLog.append(event.getLoggerName());
        formattedLog.append(" - ");
        
        // Add message
        formattedLog.append(event.getRenderedMessage());
        
        // Add throwable information if exists
        String[] throwableInfo = event.getThrowableStrRep();
        if (throwableInfo != null) {
            formattedLog.append("\n");
            for (String throwableLine : throwableInfo) {
                formattedLog.append(throwableLine).append("\n");
            }
        }
        
        return formattedLog.toString();
    }
}