import org.apache.log4j.spi.LoggingEvent;

protected void subAppend(LoggingEvent event) {
    // Assuming this method is part of a custom appender class
    // Here we simply print the log message to the console
    // You can replace this with actual logging logic as needed
    System.out.println(event.getMessage());
}