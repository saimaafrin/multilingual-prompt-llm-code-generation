import org.apache.log4j.spi.LoggingEvent;

public class LoggerExample {

    /**
     * Este método realiza la escritura
     */
    protected void subAppend(LoggingEvent event) {
        // Aquí se implementaría la lógica para escribir el evento de log
        // Por ejemplo, podríamos imprimir el mensaje del evento en la consola
        System.out.println(event.getMessage());
    }
}