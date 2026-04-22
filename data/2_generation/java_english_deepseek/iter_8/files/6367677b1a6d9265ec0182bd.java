import java.io.StringWriter;
import java.io.PrintWriter;

public class LogFormatter {

    /**
     * Formats a logging event to a writer.
     * @param event logging event to be formatted.
     * @return formatted string representation of the logging event.
     */
    public String format(final LoggingEvent event) {
        StringWriter writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);

        printWriter.println("Logging Event:");
        printWriter.println("Level: " + event.getLevel());
        printWriter.println("Message: " + event.getMessage());
        printWriter.println("Timestamp: " + event.getTimestamp());
        printWriter.println("Logger Name: " + event.getLoggerName());
        printWriter.println("Thread Name: " + event.getThreadName());

        if (event.getThrowableInfo() != null) {
            printWriter.println("Throwable: ");
            event.getThrowableInfo().printStackTrace(printWriter);
        }

        printWriter.flush();
        return writer.toString();
    }
}

// Assuming LoggingEvent class has the following methods:
// getLevel(), getMessage(), getTimestamp(), getLoggerName(), getThreadName(), getThrowableInfo()