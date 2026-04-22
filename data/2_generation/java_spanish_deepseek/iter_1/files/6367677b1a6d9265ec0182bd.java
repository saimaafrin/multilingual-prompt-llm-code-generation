import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * Formatea un evento de "logging" para un "writer".
     * @param event evento de "logging" que se va a formatear.
     * @return una cadena formateada que representa el evento de logging.
     */
    public String format(final LoggingEvent event) {
        StringBuilder formattedEvent = new StringBuilder();
        
        // Agregar la marca de tiempo
        formattedEvent.append("Timestamp: ").append(event.getTimeStamp()).append(" - ");
        
        // Agregar el nivel de log
        formattedEvent.append("Level: ").append(event.getLevel().toString()).append(" - ");
        
        // Agregar el mensaje de log
        formattedEvent.append("Message: ").append(event.getRenderedMessage()).append(" - ");
        
        // Agregar el nombre del logger
        formattedEvent.append("Logger: ").append(event.getLoggerName()).append(" - ");
        
        // Agregar el hilo que generó el log
        formattedEvent.append("Thread: ").append(event.getThreadName()).append(" - ");
        
        // Agregar la excepción si existe
        if (event.getThrowableInformation() != null) {
            formattedEvent.append("Exception: ").append(event.getThrowableInformation().getThrowable().toString());
        }
        
        return formattedEvent.toString();
    }
}