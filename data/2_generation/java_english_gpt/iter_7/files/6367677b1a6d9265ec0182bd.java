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
        printWriter.printf("Logger: %s%n", event.getLoggerName());
        
        if (event.getThrowableInformation() != null) {
            printWriter.printf("Exception: %s%n", event.getThrowableInformation().getThrowable());
        }
        
        printWriter.flush();
        return stringWriter.toString();
    }
}

class LoggingEvent {
    private long timestamp;
    private String level;
    private String message;
    private String loggerName;
    private ThrowableInformation throwableInformation;

    // Getters and constructors omitted for brevity

    public long getTimestamp() {
        return timestamp;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public ThrowableInformation getThrowableInformation() {
        return throwableInformation;
    }
}

class ThrowableInformation {
    private Throwable throwable;

    // Getters and constructors omitted for brevity

    public Throwable getThrowable() {
        return throwable;
    }
}