import org.apache.log4j.spi.LoggingEvent;

/**
 * 此方法执行实际的写入操作
 */
protected void subAppend(LoggingEvent event) {
    // 这里可以添加具体的日志写入逻辑
    // 例如：将日志事件写入文件、控制台或其他输出目标
    // 以下是一个简单的示例，将日志事件的消息打印到控制台
    System.out.println(event.getMessage());
}