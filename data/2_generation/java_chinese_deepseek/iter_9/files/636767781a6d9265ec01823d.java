import org.apache.log4j.spi.LoggingEvent;

protected void subAppend(LoggingEvent event) {
    // Assuming this method is part of a class that has access to a writer or output stream
    // For example, a FileAppender or ConsoleAppender in Log4j

    // Convert the LoggingEvent to a string representation
    String logMessage = event.getMessage().toString();

    // Example: Writing to the console
    System.out.println(logMessage);

    // If you have a specific writer or output stream, you can use it like this:
    // writer.write(logMessage);
    // writer.flush();
}