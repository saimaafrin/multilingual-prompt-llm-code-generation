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
        
        printWriter.println("Timestamp: " + event.getTimeStamp());
        printWriter.println("Level: " + event.getLevel());
        printWriter.println("Logger: " + event.getLoggerName());
        printWriter.println("Message: " + event.getRenderedMessage());
        
        if (event.getThrowableInformation() != null) {
            printWriter.println("Throwable: " + event.getThrowableInformation().getThrowable());
        }
        
        printWriter.flush();
        return stringWriter.toString();
    }
}