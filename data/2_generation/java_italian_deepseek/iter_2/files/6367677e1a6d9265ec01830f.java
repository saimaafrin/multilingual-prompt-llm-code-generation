import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * Produce una stringa formattata come specificato dal modello di conversione.
     * 
     * @param event L'evento di log da formattare.
     * @return La stringa formattata.
     */
    public String format(LoggingEvent event) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date(event.getTimeStamp()));
        
        String level = event.getLevel().toString();
        String loggerName = event.getLoggerName();
        String message = event.getMessage();
        
        return String.format("[%s] %s %s - %s", timestamp, level, loggerName, message);
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