import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    public String format(LoggingEvent event) {
        // Example format: [LEVEL] timestamp - message
        StringBuilder formattedMessage = new StringBuilder();
        formattedMessage.append("[")
                         .append(event.getLevel().toString())
                         .append("] ")
                         .append(event.getTimeStamp())
                         .append(" - ")
                         .append(event.getMessage().toString());
        return formattedMessage.toString();
    }
}