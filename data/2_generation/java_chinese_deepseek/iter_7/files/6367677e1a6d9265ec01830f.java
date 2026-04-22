import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * 根据转换模式生成格式化字符串。
     * @param event 日志事件
     * @return 格式化后的字符串
     */
    public String format(LoggingEvent event) {
        // 假设转换模式为 "[%d{yyyy-MM-dd HH:mm:ss}] %-5p %c{1}:%L - %m%n"
        String pattern = "[%d{yyyy-MM-dd HH:mm:ss}] %-5p %c{1}:%L - %m%n";
        
        // 使用Log4j的PatternLayout来格式化日志事件
        org.apache.log4j.PatternLayout layout = new org.apache.log4j.PatternLayout(pattern);
        return layout.format(event);
    }
}