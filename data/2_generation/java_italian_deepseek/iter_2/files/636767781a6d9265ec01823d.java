import org.apache.log4j.spi.LoggingEvent;

public class Logger {

    /**
     * Questo metodo esegue la scrittura effettiva
     */
    protected void subAppend(LoggingEvent event) {
        // Implementazione della scrittura effettiva del log
        // Esempio: stampa il messaggio del log
        System.out.println(event.getMessage());
    }
}