import org.apache.log4j.spi.LoggingEvent;

/**
 * Questo metodo esegue la scrittura effettiva
 */
protected void subAppend(LoggingEvent event) {
    // Implementazione della scrittura effettiva del log
    // Ad esempio, scrivere il messaggio su un file o su console
    System.out.println(event.getMessage());
}