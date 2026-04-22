import org.apache.log4j.spi.LoggingEvent;
import java.io.StringWriter;
import java.io.PrintWriter;

public class LoggerFormatter {

    /** 
     * Formats a logging event to a writer.
     * @param event logging event to be formatted.
     */
    public String format(final LoggingEvent event) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        
        printWriter.printf("Timestamp: %d%n", event.getTimeStamp());
        printWriter.printf("Level: %s%n", event.getLevel());
        printWriter.printf("Logger: %s%n", event.getLoggerName());
        printWriter.printf("Message: %s%n", event.getRenderedMessage());
        
        if (event.getThrowableInformation() != null) {
            printWriter.printf("Exception: %s%n", event.getThrowableInformation().getThrowable().toString());
        }
        
        printWriter.flush();
        return stringWriter.toString();
    }
}