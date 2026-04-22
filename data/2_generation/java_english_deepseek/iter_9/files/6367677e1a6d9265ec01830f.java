import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * Produces a formatted string as specified by the conversion pattern.
     * 
     * @param event The LoggingEvent containing the log information.
     * @return A formatted string representing the log event.
     */
    public String format(LoggingEvent event) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date(event.getTimeStamp()));
        
        StringBuilder formattedMessage = new StringBuilder();
        formattedMessage.append(timestamp)
                         .append(" [")
                         .append(event.getLevel())
                         .append("] ")
                         .append(event.getLoggerName())
                         .append(" - ")
                         .append(event.getMessage());
        
        return formattedMessage.toString();
    }
}

class LoggingEvent {
    private long timeStamp;
    private String level;
    private String loggerName;
    private String message;

    public LoggingEvent(long timeStamp, String level, String loggerName, String message) {
        this.timeStamp = timeStamp;
        this.level = level;
        this.loggerName = loggerName;
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
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
}