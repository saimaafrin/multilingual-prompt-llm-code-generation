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
        formattedEvent.append("[").append(event.getTimeStamp()).append("] ");
        
        // Agregar el nivel de log
        formattedEvent.append("[").append(event.getLevel().toString()).append("] ");
        
        // Agregar el nombre del logger
        formattedEvent.append("[").append(event.getLoggerName()).append("] ");
        
        // Agregar el mensaje de log
        formattedEvent.append(event.getRenderedMessage());
        
        // Agregar el stack trace si existe
        String[] throwableStrRep = event.getThrowableStrRep();
        if (throwableStrRep != null) {
            formattedEvent.append("\n");
            for (String line : throwableStrRep) {
                formattedEvent.append(line).append("\n");
            }
        }
        
        return formattedEvent.toString();
    }
}