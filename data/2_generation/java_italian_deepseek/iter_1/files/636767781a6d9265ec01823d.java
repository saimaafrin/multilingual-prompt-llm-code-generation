import org.apache.log4j.spi.LoggingEvent;

public class Logger {

    /**
     * Questo metodo esegue la scrittura effettiva
     */
    protected void subAppend(LoggingEvent event) {
        // Implementazione della scrittura effettiva del log
        // Ad esempio, scrivere su console o file
        System.out.println(event.getMessage());
    }
}