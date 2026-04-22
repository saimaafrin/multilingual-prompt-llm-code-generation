import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * 根据转换模式生成格式化字符串。
     * @param event 日志事件对象
     * @return 格式化后的日志字符串
     */
    public String format(LoggingEvent event) {
        // 假设 LoggingEvent 类有以下方法：
        // getTimestamp() 返回日志时间戳
        // getLevel() 返回日志级别
        // getMessage() 返回日志消息

        // 格式化时间戳
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(new Date(event.getTimestamp()));

        // 格式化日志级别
        String level = event.getLevel().toString();

        // 格式化日志消息
        String message = event.getMessage();

        // 组合成最终的格式化字符串
        return String.format("[%s] %s: %s", formattedDate, level, message);
    }
}

// 假设 LoggingEvent 类的定义如下：
class LoggingEvent {
    private long timestamp;
    private Level level;
    private String message;

    public LoggingEvent(long timestamp, Level level, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Level getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}

// 假设 Level 枚举类的定义如下：
enum Level {
    INFO, WARN, ERROR, DEBUG
}