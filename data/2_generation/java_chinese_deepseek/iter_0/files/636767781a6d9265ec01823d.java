import org.apache.log4j.spi.LoggingEvent;

protected void subAppend(LoggingEvent event) {
    // Assuming this method is part of a class that has a writer or output stream
    // Here we simply print the event's message to the console
    System.out.println(event.getMessage());
}