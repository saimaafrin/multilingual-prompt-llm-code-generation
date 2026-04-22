import org.apache.log4j.spi.LoggingEvent;

public class LoggerFormatter {

    /** 
     * Formatea un evento de "logging" para un "writer".
     * @param event evento de "logging" que se va a formatear.
     */
    public String format(final LoggingEvent event) {
        StringBuilder formattedEvent = new StringBuilder();
        
        formattedEvent.append("Timestamp: ").append(event.getTimeStamp()).append("\n");
        formattedEvent.append("Level: ").append(event.getLevel()).append("\n");
        formattedEvent.append("Logger: ").append(event.getLoggerName()).append("\n");
        formattedEvent.append("Message: ").append(event.getRenderedMessage()).append("\n");
        
        if (event.getThrowableInformation() != null) {
            formattedEvent.append("Exception: ").append(event.getThrowableInformation().getThrowable()).append("\n");
        }
        
        return formattedEvent.toString();
    }
}