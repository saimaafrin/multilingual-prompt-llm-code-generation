import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * 根据转换模式生成格式化字符串。
     * @param event 日志事件
     * @return 格式化后的字符串
     */
    public String format(LoggingEvent event) {
        // 假设我们使用简单的格式：时间戳 - 日志级别 - 消息
        StringBuilder formattedMessage = new StringBuilder();
        formattedMessage.append(event.getTimeStamp())
                         .append(" - ")
                         .append(event.getLevel().toString())
                         .append(" - ")
                         .append(event.getMessage().toString());
        return formattedMessage.toString();
    }
}