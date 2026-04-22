import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * Formatea un evento de "logging" para un "writer".
     * @param event evento de "logging" que se va a formatear.
     * @return una cadena que representa el evento formateado.
     */
    public String format(final LoggingEvent event) {
        StringBuilder formattedEvent = new StringBuilder();
        
        // Formato básico: [Nivel] Mensaje
        formattedEvent.append("[")
                      .append(event.getLevel().toString())
                      .append("] ")
                      .append(event.getRenderedMessage())
                      .append("\n");
        
        // Si hay un Throwable, agregar su stack trace
        if (event.getThrowableInformation() != null) {
            formattedEvent.append("Exception: ")
                          .append(event.getThrowableInformation().getThrowable().toString())
                          .append("\n");
            for (StackTraceElement element : event.getThrowableInformation().getThrowable().getStackTrace()) {
                formattedEvent.append("\t")
                              .append(element.toString())
                              .append("\n");
            }
        }
        
        return formattedEvent.toString();
    }
}