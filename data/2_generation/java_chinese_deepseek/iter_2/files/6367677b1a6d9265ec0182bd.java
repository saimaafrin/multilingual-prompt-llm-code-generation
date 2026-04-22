import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * 将日志事件格式化为写入器。
     * @param event 要格式化的日志事件。
     * @return 格式化后的日志字符串。
     */
    public String format(final LoggingEvent event) {
        StringBuilder formattedMessage = new StringBuilder();
        
        // 添加时间戳
        formattedMessage.append(event.getTimeStamp()).append(" ");
        
        // 添加日志级别
        formattedMessage.append(event.getLevel().toString()).append(" ");
        
        // 添加日志消息
        formattedMessage.append(event.getRenderedMessage());
        
        // 添加换行符
        formattedMessage.append("\n");
        
        return formattedMessage.toString();
    }
}