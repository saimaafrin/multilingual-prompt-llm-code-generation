import org.apache.log4j.spi.LoggingEvent;

/**
 * यह विधि वास्तविक लेखन करती है
 */
protected void subAppend(LoggingEvent event) {
    // Implementation of the method
    // This method is typically used in custom appenders to handle the actual logging
    // For example, writing the log event to a file, console, or other output streams.
    
    // Example implementation:
    String logMessage = event.getRenderedMessage();
    System.out.println(logMessage);  // Simple example: print the log message to the console
}