import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * 根据转换模式生成格式化字符串。
     * @param event 日志事件对象
     * @return 格式化后的日志字符串
     */
    public String format(LoggingEvent event) {
        // 假设 LoggingEvent 类有以下字段：
        // String message, Date timestamp, String level, String loggerName

        // 创建一个日期格式化器
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 格式化日志信息
        String formattedLog = String.format("[%s] %s %s - %s",
                dateFormat.format(event.getTimestamp()),
                event.getLevel(),
                event.getLoggerName(),
                event.getMessage());

        return formattedLog;
    }
}

// 假设的 LoggingEvent 类
class LoggingEvent {
    private String message;
    private Date timestamp;
    private String level;
    private String loggerName;

    public LoggingEvent(String message, Date timestamp, String level, String loggerName) {
        this.message = message;
        this.timestamp = timestamp;
        this.level = level;
        this.loggerName = loggerName;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getLevel() {
        return level;
    }

    public String getLoggerName() {
        return loggerName;
    }
}