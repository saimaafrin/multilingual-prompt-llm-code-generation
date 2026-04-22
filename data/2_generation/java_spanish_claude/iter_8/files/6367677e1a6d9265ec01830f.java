import org.apache.log4j.spi.LoggingEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLogFormatter {

    private static final String DEFAULT_PATTERN = "[%d{yyyy-MM-dd HH:mm:ss}] [%p] %c - %m%n";
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String format(LoggingEvent event) {
        if (event == null) {
            return "";
        }

        StringBuilder formattedMessage = new StringBuilder();
        
        // Add timestamp
        formattedMessage.append("[")
            .append(dateFormat.format(new Date(event.getTimeStamp())))
            .append("] ");

        // Add log level
        formattedMessage.append("[")
            .append(event.getLevel().toString())
            .append("] ");

        // Add logger name
        formattedMessage.append(event.getLoggerName())
            .append(" - ");

        // Add message
        formattedMessage.append(event.getRenderedMessage());

        // Add new line
        formattedMessage.append(System.lineSeparator());

        // Add throwable information if exists
        String[] throwableInfo = event.getThrowableStrRep();
        if (throwableInfo != null) {
            for (String throwableLine : throwableInfo) {
                formattedMessage.append(throwableLine)
                    .append(System.lineSeparator());
            }
        }

        return formattedMessage.toString();
    }
}