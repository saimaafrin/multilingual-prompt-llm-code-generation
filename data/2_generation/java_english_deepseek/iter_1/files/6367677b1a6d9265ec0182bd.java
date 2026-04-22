import java.io.StringWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * Formats a logging event to a writer.
     * @param event logging event to be formatted.
     * @return formatted string representation of the logging event.
     */
    public String format(final LoggingEvent event) {
        StringWriter writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);

        // Format the timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date(event.getTimeStamp()));

        // Format the log level
        String level = event.getLevel().toString();

        // Format the logger name
        String loggerName = event.getLoggerName();

        // Format the message
        String message = event.getMessage().toString();

        // Format the throwable (if any)
        String throwableStr = "";
        if (event.getThrowableInformation() != null) {
            Throwable throwable = event.getThrowableInformation().getThrowable();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            throwable.printStackTrace(pw);
            throwableStr = sw.toString();
        }

        // Combine all parts into a single formatted string
        printWriter.printf("[%s] %s %s - %s%n%s", timestamp, level, loggerName, message, throwableStr);

        return writer.toString();
    }
}

// Assuming LoggingEvent class has the following methods:
// long getTimeStamp()
// Level getLevel()
// String getLoggerName()
// Object getMessage()
// ThrowableInformation getThrowableInformation()

// Example LoggingEvent class (for reference):
class LoggingEvent {
    private long timeStamp;
    private Level level;
    private String loggerName;
    private Object message;
    private ThrowableInformation throwableInformation;

    public long getTimeStamp() {
        return timeStamp;
    }

    public Level getLevel() {
        return level;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public Object getMessage() {
        return message;
    }

    public ThrowableInformation getThrowableInformation() {
        return throwableInformation;
    }
}

// Example Level class (for reference):
class Level {
    private String level;

    public Level(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return level;
    }
}

// Example ThrowableInformation class (for reference):
class ThrowableInformation {
    private Throwable throwable;

    public ThrowableInformation(Throwable throwable) {
        this.throwable = throwable;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}