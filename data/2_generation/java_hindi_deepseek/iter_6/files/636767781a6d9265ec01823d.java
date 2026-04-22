import org.apache.log4j.spi.LoggingEvent;

/**
 * यह विधि वास्तविक लेखन करती है
 */
protected void subAppend(LoggingEvent event) {
    // Implementation of the method
    // This method is responsible for the actual writing of the log event
    // For example, it could write the event to a file, console, or other output destination
    // Here is a simple example that prints the event message to the console
    System.out.println(event.getMessage());
}