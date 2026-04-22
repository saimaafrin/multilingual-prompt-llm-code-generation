import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerFormatter {

    /**
     * Produces a formatted string as specified by the conversion pattern.
     */
    public String format(LoggingEvent event) {
        StringBuilder formattedString = new StringBuilder();
        
        // Example conversion pattern
        String pattern = "[%d{ISO8601}] [%p] [%c] - %m%n";
        
        // Replace placeholders with actual values from the LoggingEvent
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(event.getTimestamp()));
        String level = event.getLevel().toString();
        String loggerName = event.getLoggerName();
        String message = event.getMessage();
        
        // Build the formatted string
        formattedString.append(pattern.replace("%d{ISO8601}", date)
                                      .replace("%p", level)
                                      .replace("%c", loggerName)
                                      .replace("%m", message)
                                      .replace("%n", System.lineSeparator()));
        
        return formattedString.toString();
    }
}

class LoggingEvent {
    private long timestamp;
    private LogLevel level;
    private String loggerName;
    private String message;

    public LoggingEvent(long timestamp, LogLevel level, String loggerName, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.loggerName = loggerName;
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public String getMessage() {
        return message;
    }
}

enum LogLevel {
    DEBUG, INFO, WARN, ERROR, FATAL
}