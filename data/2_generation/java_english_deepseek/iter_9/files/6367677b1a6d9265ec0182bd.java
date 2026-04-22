import java.io.StringWriter;
import java.io.PrintWriter;

public class LogFormatter {

    /**
     * Formats a logging event to a writer.
     * @param event logging event to be formatted.
     * @return the formatted logging event as a String.
     */
    public String format(final LoggingEvent event) {
        StringWriter writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);

        // Example formatting: Log level, message, and timestamp
        printWriter.printf("[%s] %s - %s%n", 
            event.getLevel(), 
            event.getTimestamp(), 
            event.getMessage());

        // If there's a throwable, append its stack trace
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace(printWriter);
        }

        printWriter.flush();
        return writer.toString();
    }
}

// Assuming LoggingEvent class has the following methods:
// class LoggingEvent {
//     String getLevel();
//     long getTimestamp();
//     String getMessage();
//     Throwable getThrowable();
// }