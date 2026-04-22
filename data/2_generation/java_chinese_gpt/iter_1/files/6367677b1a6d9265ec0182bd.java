import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {
    /**
     * 将日志事件格式化为写入器。
     * @param event 要格式化的日志事件。
     * @return 格式化后的日志字符串。
     */
    public String format(final LoggingEvent event) {
        StringBuilder formattedLog = new StringBuilder();
        formattedLog.append("Timestamp: ").append(event.getTimeStamp()).append("\n");
        formattedLog.append("Level: ").append(event.getLevel()).append("\n");
        formattedLog.append("Logger: ").append(event.getLoggerName()).append("\n");
        formattedLog.append("Message: ").append(event.getRenderedMessage()).append("\n");
        if (event.getThrowableInformation() != null) {
            formattedLog.append("Exception: ").append(event.getThrowableInformation().getThrowable()).append("\n");
        }
        return formattedLog.toString();
    }
}