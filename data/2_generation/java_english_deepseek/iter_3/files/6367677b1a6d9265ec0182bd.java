import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * Formats a logging event to a writer.
     * @param event logging event to be formatted.
     * @return formatted string representation of the logging event.
     */
    public String format(final LoggingEvent event) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date(event.getTimeStamp()));
        String level = event.getLevel().toString();
        String message = event.getMessage();
        String loggerName = event.getLoggerName();

        return String.format("[%s] %s %s - %s", timestamp, level, loggerName, message);
    }
}

// Assuming LoggingEvent class has the following methods:
// getTimeStamp(), getLevel(), getMessage(), getLoggerName()
class LoggingEvent {
    private long timeStamp;
    private Level level;
    private String message;
    private String loggerName;

    public LoggingEvent(long timeStamp, Level level, String message, String loggerName) {
        this.timeStamp = timeStamp;
        this.level = level;
        this.message = message;
        this.loggerName = loggerName;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public Level getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public String getLoggerName() {
        return loggerName;
    }
}

// Assuming Level is an enum representing log levels
enum Level {
    INFO, WARN, ERROR, DEBUG
}