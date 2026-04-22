import org.apache.log4j.spi.LoggingEvent;

/**
 * यह विधि वास्तविक लेखन करती है
 */
protected void subAppend(LoggingEvent event) {
    // Implementation of the method
    // This method is responsible for the actual writing of the log event
    // You can customize this method to handle the LoggingEvent as needed
    // For example, writing to a file, console, or other output streams
    System.out.println(event.getMessage());
}