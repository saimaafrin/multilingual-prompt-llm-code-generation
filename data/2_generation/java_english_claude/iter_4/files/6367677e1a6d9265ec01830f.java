import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.Layout;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLayout extends Layout {

    private static final String DEFAULT_PATTERN = "%d [%t] %-5p %c - %m%n";
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

    public String format(LoggingEvent event) {
        StringBuilder sb = new StringBuilder();
        
        // Add timestamp
        Date timestamp = new Date(event.getTimeStamp());
        sb.append(dateFormat.format(timestamp)).append(" ");
        
        // Add thread name
        sb.append("[").append(event.getThreadName()).append("] ");
        
        // Add log level with padding
        String level = event.getLevel().toString();
        sb.append(String.format("%-5s", level)).append(" ");
        
        // Add logger name
        sb.append(event.getLoggerName()).append(" - ");
        
        // Add message
        sb.append(event.getRenderedMessage());
        
        // Add new line
        sb.append(System.lineSeparator());
        
        // Add throwable info if exists
        String[] throwableInfo = event.getThrowableStrRep();
        if (throwableInfo != null) {
            for (String line : throwableInfo) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        
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