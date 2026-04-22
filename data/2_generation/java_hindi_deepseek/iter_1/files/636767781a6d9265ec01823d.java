import org.apache.log4j.spi.LoggingEvent;

/**
 * यह विधि वास्तविक लेखन करती है
 */
protected void subAppend(LoggingEvent event) {
    // Implementation of the method
    // For example, writing the log event to a file or console
    System.out.println(event.getMessage());
}