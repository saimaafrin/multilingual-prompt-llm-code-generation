import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * Formatea un evento de "logging" para un "writer".
     * @param event evento de "logging" que se va a formatear.
     * @return una cadena que representa el evento formateado.
     */
    public String format(final LoggingEvent event) {
        StringBuilder formattedEvent = new StringBuilder();
        
        // Agregar la marca de tiempo
        formattedEvent.append("Timestamp: ").append(event.getTimeStamp()).append("\n");
        
        // Agregar el nivel de log
        formattedEvent.append("Level: ").append(event.getLevel().toString()).append("\n");
        
        // Agregar el mensaje de log
        formattedEvent.append("Message: ").append(event.getRenderedMessage()).append("\n");
        
        // Agregar el nombre del logger
        formattedEvent.append("Logger: ").append(event.getLoggerName()).append("\n");
        
        // Agregar el hilo que generó el log
        formattedEvent.append("Thread: ").append(event.getThreadName()).append("\n");
        
        // Agregar la traza de la excepción si existe
        if (event.getThrowableInformation() != null) {
            formattedEvent.append("Exception: ").append(event.getThrowableStrRep()).append("\n");
        }
        
        return formattedEvent.toString();
    }
}