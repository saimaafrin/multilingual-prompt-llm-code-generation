import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * 根据转换模式生成格式化字符串。
     * 
     * @param event 日志事件对象
     * @return 格式化后的字符串
     */
    public String format(LoggingEvent event) {
        // 这里假设转换模式是 "[%p] %c - %m%n"
        // 其中 %p 是日志级别，%c 是日志名称，%m 是日志消息，%n 是换行符
        String level = event.getLevel().toString();
        String loggerName = event.getLoggerName();
        String message = event.getRenderedMessage();
        
        // 格式化字符串
        return String.format("[%s] %s - %s%n", level, loggerName, message);
    }
}