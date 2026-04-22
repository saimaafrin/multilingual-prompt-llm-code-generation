import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * 根据转换模式生成格式化字符串。
     * @param event 日志事件对象
     * @return 格式化后的日志字符串
     */
    public String format(LoggingEvent event) {
        // 假设LoggingEvent类有以下方法：
        // getMessage() - 获取日志消息
        // getLevel() - 获取日志级别
        // getTimestamp() - 获取时间戳
        // getLoggerName() - 获取日志记录器名称

        // 格式化时间戳
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(new Date(event.getTimestamp()));

        // 构建格式化字符串
        return String.format("[%s] %s %s - %s",
                formattedDate,
                event.getLevel(),
                event.getLoggerName(),
                event.getMessage());
    }
}

// 假设LoggingEvent类的定义如下：
class LoggingEvent {
    private String message;
    private String level;
    private long timestamp;
    private String loggerName;

    public LoggingEvent(String message, String level, long timestamp, String loggerName) {
        this.message = message;
        this.level = level;
        this.timestamp = timestamp;
        this.loggerName = loggerName;
    }

    public String getMessage() {
        return message;
    }

    public String getLevel() {
        return level;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getLoggerName() {
        return loggerName;
    }
}