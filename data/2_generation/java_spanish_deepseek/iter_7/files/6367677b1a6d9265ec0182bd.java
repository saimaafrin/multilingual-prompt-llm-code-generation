import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * Formatea un evento de "logging" para un "writer".
     * @param event evento de "logging" que se va a formatear.
     * @return una cadena formateada que representa el evento de logging.
     */
    public String format(final LoggingEvent event) {
        StringBuilder formattedEvent = new StringBuilder();
        
        // Formato básico: [Nivel] Mensaje
        formattedEvent.append("[")
                      .append(event.getLevel().toString())
                      .append("] ")
                      .append(event.getMessage().toString());
        
        // Opcional: Agregar información adicional como el tiempo y el nombre del logger
        formattedEvent.append(" - ")
                      .append(event.getTimeStamp())
                      .append(" - ")
                      .append(event.getLoggerName());
        
        return formattedEvent.toString();
    }
}