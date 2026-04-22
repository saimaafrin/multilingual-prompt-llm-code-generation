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
        // Date timestamp: 日志时间戳
        // String level: 日志级别
        // String message: 日志消息
        // String loggerName: 日志记录器名称

        // 创建一个日期格式化器
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 格式化日志时间戳
        String formattedTimestamp = dateFormat.format(event.getTimestamp());

        // 构建格式化后的日志字符串
        String formattedLog = String.format("[%s] %s %s - %s",
                formattedTimestamp,
                event.getLevel(),
                event.getLoggerName(),
                event.getMessage());

        return formattedLog;
    }
}

// 假设的 LoggingEvent 类
class LoggingEvent {
    private Date timestamp;
    private String level;
    private String message;
    private String loggerName;

    public LoggingEvent(Date timestamp, String level, String message, String loggerName) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
        this.loggerName = loggerName;
    }

    public Date getTimestamp() {
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
}