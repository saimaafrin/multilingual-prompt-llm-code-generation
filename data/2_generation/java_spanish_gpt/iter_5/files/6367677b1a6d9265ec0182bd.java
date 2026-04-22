import org.apache.log4j.spi.LoggingEvent;

public class LoggerFormatter {

    /** 
     * Formatea un evento de "logging" para un "writer".
     * @param event evento de "logging" que se va a formatear.
     */
    public String format(final LoggingEvent event) {
        StringBuilder formattedEvent = new StringBuilder();
        
        // Formatear la fecha y hora del evento
        formattedEvent.append(event.getTimeStamp()).append(" - ");
        
        // Obtener el nivel de log
        formattedEvent.append(event.getLevel().toString()).append(" - ");
        
        // Obtener el nombre de la clase que genera el evento
        formattedEvent.append(event.getLoggerName()).append(" - ");
        
        // Obtener el mensaje del evento
        formattedEvent.append(event.getRenderedMessage());
        
        // Si hay excepciones, añadirlas al formato
        if (event.getThrowableInformation() != null) {
            formattedEvent.append("\n").append(event.getThrowableInformation().getThrowable().toString());
        }
        
        return formattedEvent.toString();
    }
}