import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    /**
     * Formats a logging event to a writer.
     * @param event logging event to be formatted.
     */
    public void format(LogEvent event) {
        StringBuilder sb = new StringBuilder();
        
        // Add timestamp
        sb.append(dateFormat.format(new Date(event.getTimestamp())));
        sb.append(" ");
        
        // Add log level
        sb.append("[").append(event.getLevel()).append("] ");
        
        // Add logger name
        sb.append(event.getLoggerName());
        sb.append(" - ");
        
        // Add message
        sb.append(event.getMessage());
        
        // Add throwable if exists
        Throwable throwable = event.getThrowable();
        if (throwable != null) {
            sb.append("\n");
            for (StackTraceElement element : throwable.getStackTrace()) {
                sb.append("\tat ").append(element.toString()).append("\n");
            }
        }
        
        // Add newline
        sb.append("\n");
        
        try {
            Writer writer = event.getWriter();
            writer.write(sb.toString());
            writer.flush();
        } catch (Exception e) {
            System.err.println("Error writing log event: " + e.getMessage());
        }
    }
}

// Supporting class for log events
class LogEvent {
    private long timestamp;
    private String level;
    private String loggerName;
    private String message;
    private Throwable throwable;
    private Writer writer;
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public String getLevel() {
        return level;
    }
    
    public String getLoggerName() {
        return loggerName;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Throwable getThrowable() {
        return throwable;
    }
    
    public Writer getWriter() {
        return writer;
    }
}