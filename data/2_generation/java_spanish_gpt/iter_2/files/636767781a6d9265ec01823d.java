import org.apache.log4j.spi.LoggingEvent;

public class Logger {
    
    /**
     * Este método realiza la escritura
     */
    protected void subAppend(LoggingEvent event) {
        // Implementación de la escritura del evento de registro
        if (event != null) {
            System.out.println("Logging event: " + event.getMessage());
        } else {
            System.out.println("No event to log.");
        }
    }
}