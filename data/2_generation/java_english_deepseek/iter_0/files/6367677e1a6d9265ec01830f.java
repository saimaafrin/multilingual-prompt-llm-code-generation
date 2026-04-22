import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * Produces a formatted string as specified by the conversion pattern.
     * @param event The LoggingEvent containing the log information.
     * @return A formatted string representing the log event.
     */
    public String format(LoggingEvent event) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date(event.getTimeStamp()));
        String level = event.getLevel().toString();
        String message = event.getMessage();

        return String.format("[%s] %s: %s", timestamp, level, message);
    }
}

class LoggingEvent {
    private long timeStamp;
    private String level;
    private String message;

    public LoggingEvent(long timeStamp, String level, String message) {
        this.timeStamp = timeStamp;
        this.level = level;
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}