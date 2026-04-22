import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * 将日志事件格式化为写入器。
     * @param event 要格式化的日志事件。
     * @return 格式化后的日志字符串。
     */
    public String format(final LoggingEvent event) {
        if (event == null) {
            return "";
        }

        StringBuilder formattedMessage = new StringBuilder();
        formattedMessage.append("[").append(event.getLevel().toString()).append("] ");
        formattedMessage.append(event.getTimeStamp()).append(" - ");
        formattedMessage.append(event.getLoggerName()).append(" - ");
        formattedMessage.append(event.getRenderedMessage());

        return formattedMessage.toString();
    }
}