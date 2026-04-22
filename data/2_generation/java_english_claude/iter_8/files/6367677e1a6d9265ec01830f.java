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
        builder.append(dateFormat.format(new Date(event.getTimeStamp())));
        builder.append(" [");
        
        // Add thread name
        builder.append(event.getThreadName());
        builder.append("] ");
        
        // Add log level with padding
        String level = event.getLevel().toString();
        builder.append(String.format("%-5s", level));
        builder.append(" ");
        
        // Add logger name
        builder.append(event.getLoggerName());
        builder.append(" - ");
        
        // Add message
        builder.append(event.getRenderedMessage());
        
        // Add new line
        builder.append(System.lineSeparator());
        
        // Add throwable if exists
        String[] throwableStrRep = event.getThrowableStrRep();
        if (throwableStrRep != null) {
            for (String line : throwableStrRep) {
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