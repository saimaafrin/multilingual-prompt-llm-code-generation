import org.apache.log4j.spi.LoggingEvent;

/**
 * 此方法执行实际的写入操作
 */
protected void subAppend(LoggingEvent event) {
    // 这里假设我们有一个输出流或日志记录器来执行实际的写入操作
    // 例如，将日志事件写入控制台或文件
    System.out.println(event.getMessage());
}