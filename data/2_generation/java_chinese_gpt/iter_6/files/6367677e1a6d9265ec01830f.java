import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerFormatter {

    /**
     * 根据转换模式生成格式化字符串。
     */
    public String format(LoggingEvent event) {
        StringBuilder formattedString = new StringBuilder();
        
        // Example of formatting: timestamp, log level, and message
        formattedString.append("[")
                       .append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(event.getTimestamp())))
                       .append("] ")
                       .append(event.getLevel())
                       .append(": ")
                       .append(event.getMessage());
        
        return formattedString.toString();
    }
}

class LoggingEvent {
    private long timestamp;
    private String level;
    private String message;

    public LoggingEvent(long timestamp, String level, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
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
}