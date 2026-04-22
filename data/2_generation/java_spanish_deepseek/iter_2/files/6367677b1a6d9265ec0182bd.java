import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * Formatea un evento de "logging" para un "writer".
     * @param event evento de "logging" que se va a formatear.
     * @return una cadena que representa el evento formateado.
     */
    public String format(final LoggingEvent event) {
        StringBuilder formattedEvent = new StringBuilder();
        
        // Formato básico: [Nivel] [Hora] [Mensaje]
        formattedEvent.append("[")
                      .append(event.getLevel().toString())
                      .append("] [")
                      .append(event.getTimeStamp())
                      .append("] ")
                      .append(event.getRenderedMessage())
                      .append("\n");
        
        return formattedEvent.toString();
    }
}