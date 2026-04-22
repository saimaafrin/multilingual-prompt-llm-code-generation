import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.Layout;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLogFormatter extends Layout {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
    
    @Override
    public String format(final LoggingEvent event) {
        StringBuilder sb = new StringBuilder();
        
        // Add timestamp
        Date timestamp = new Date(event.getTimeStamp());
        sb.append(dateFormat.format(timestamp));
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
            for (String line : throwableInfo) {
                sb.append(line).append("\n");
            }
        }
        
        // Add new line
        sb.append("\n");
        
        return sb.toString();
    }

    @Override
    public boolean ignoresThrowable() {
        return false;
    }

    @Override
    public void activateOptions() {
        // No options to activate
    }
}