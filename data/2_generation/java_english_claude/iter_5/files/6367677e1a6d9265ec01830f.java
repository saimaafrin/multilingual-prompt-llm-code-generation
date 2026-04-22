import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.Layout;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLayout extends Layout {

    private static final String DEFAULT_PATTERN = "%d [%t] %-5p %c - %m%n";
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

    public String format(LoggingEvent event) {
        StringBuilder builder = new StringBuilder();
        
        // Add timestamp
        Date timestamp = new Date(event.getTimeStamp());
        builder.append(dateFormat.format(timestamp));
        builder.append(" ");
        
        // Add thread name
        builder.append("[");
        builder.append(event.getThreadName());
        builder.append("] ");
        
        // Add log level
        builder.append(String.format("%-5s", event.getLevel().toString()));
        builder.append(" ");
        
        // Add logger name
        builder.append(event.getLoggerName());
        builder.append(" - ");
        
        // Add message
        builder.append(event.getRenderedMessage());
        
        // Add new line
        builder.append(System.lineSeparator());
        
        // Add throwable if exists
        String[] throwableInfo = event.getThrowableStrRep();
        if (throwableInfo != null) {
            for (String line : throwableInfo) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }
        }
        
        return builder.toString();
    }

    @Override
    public void activateOptions() {
        // No options to activate
    }

    @Override
    public boolean ignoresThrowable() {
        return false;
    }
}