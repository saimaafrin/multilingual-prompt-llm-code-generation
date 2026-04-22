import java.io.StringWriter;
import java.io.PrintWriter;

public class LoggerFormatter {

    /** 
     * Formats a logging event to a writer.
     * @param event logging event to be formatted.
     */
    public String format(final LoggingEvent event) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        
        printWriter.printf("Timestamp: %s%n", event.getTimestamp());
        printWriter.printf("Level: %s%n", event.getLevel());
        printWriter.printf("Message: %s%n", event.getMessage());
        
        if (event.getThrowable() != null) {
            printWriter.printf("Throwable: %s%n", event.getThrowable().getMessage());
        }
        
        printWriter.flush();
        return stringWriter.toString();
    }
}

class LoggingEvent {
    private long timestamp;
    private String level;
    private String message;
    private Throwable throwable;

    public LoggingEvent(long timestamp, String level, String message, Throwable throwable) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
        this.throwable = throwable;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}