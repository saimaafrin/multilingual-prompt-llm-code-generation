import org.apache.log4j.spi.LoggingEvent;

public class LoggerAppender {

    /**
     * Este método realiza la escritura
     */
    protected void subAppend(LoggingEvent event) {
        if (event != null) {
            // Aquí se puede agregar la lógica para procesar el evento de registro
            System.out.println("Logging event: " + event.getMessage());
        } else {
            System.out.println("No logging event provided.");
        }
    }
}