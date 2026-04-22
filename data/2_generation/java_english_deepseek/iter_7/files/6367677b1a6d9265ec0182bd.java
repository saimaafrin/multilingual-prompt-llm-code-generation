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
        String message = event.getMessage().toString();
        String loggerName = event.getLoggerName();

        return String.format("[%s] %s %s - %s", timestamp, level, loggerName, message);
    }
}

// Assuming LoggingEvent class has the following methods:
// getTimeStamp(): returns the timestamp of the event as a long
// getLevel(): returns the logging level (e.g., INFO, ERROR)
// getMessage(): returns the message of the event
// getLoggerName(): returns the name of the logger