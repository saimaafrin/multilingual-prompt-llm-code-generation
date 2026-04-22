import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * Formats a logging event to a writer.
     * @param event logging event to be formatted.
     * @return formatted string representation of the logging event.
     */
    public String format(final LoggingEvent event) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date(event.getTimeStamp()));
        
        StringBuilder formattedMessage = new StringBuilder();
        formattedMessage.append("[").append(timestamp).append("] ");
        formattedMessage.append("[").append(event.getLevel().toString()).append("] ");
        formattedMessage.append(event.getMessage());
        
        if (event.getThrowableStrRep() != null) {
            formattedMessage.append("\n");
            for (String line : event.getThrowableStrRep()) {
                formattedMessage.append(line).append("\n");
            }
        }
        
        return formattedMessage.toString();
    }
}

// Assuming LoggingEvent class has the following methods:
// - getTimeStamp(): returns the timestamp of the event as a long
// - getLevel(): returns the log level (e.g., INFO, ERROR)
// - getMessage(): returns the log message as a String
// - getThrowableStrRep(): returns the stack trace as a String array (if any)