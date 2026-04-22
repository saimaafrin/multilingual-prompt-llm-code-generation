import org.apache.log4j.spi.LoggingEvent;

public class LoggerAppender {

    /**
     * 此方法执行实际的写入操作
     */
    protected void subAppend(LoggingEvent event) {
        // 实际的写入操作，例如将日志事件写入文件或控制台
        if (event != null) {
            System.out.println("Logging Event: " + event.getMessage());
        } else {
            System.out.println("No event to log.");
        }
    }
}