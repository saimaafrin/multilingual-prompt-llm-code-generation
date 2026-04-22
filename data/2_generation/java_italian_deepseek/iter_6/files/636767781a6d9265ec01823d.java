import org.apache.log4j.spi.LoggingEvent;

protected void subAppend(LoggingEvent event) {
    // Implementation of the actual writing logic
    // For example, writing the log event to a file or console
    System.out.println(event.getMessage());
}