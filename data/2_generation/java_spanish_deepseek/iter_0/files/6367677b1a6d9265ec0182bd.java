import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * Formatea un evento de "logging" para un "writer".
     * @param event evento de "logging" que se va a formatear.
     * @return una cadena formateada que representa el evento de logging.
     */
    public String format(final LoggingEvent event) {
        // Formato básico: [Nivel] Mensaje
        return "[" + event.getLevel().toString() + "] " + event.getRenderedMessage();
    }
}