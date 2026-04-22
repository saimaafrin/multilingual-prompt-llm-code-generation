import org.apache.log4j.spi.LoggingEvent;

public class Logger {

    /**
     * Este método realiza la escritura
     */
    protected void subAppend(LoggingEvent event) {
        // Implementación de la escritura del evento de logging
        // Aquí puedes agregar la lógica para manejar el evento de logging
        // Por ejemplo, escribir en un archivo, consola, etc.
        System.out.println(event.getMessage());
    }
}