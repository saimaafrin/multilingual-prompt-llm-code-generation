import org.apache.log4j.spi.LoggingEvent;

/**
 * Questo metodo esegue la scrittura effettiva
 */
protected void subAppend(LoggingEvent event) {
    // Implementazione della scrittura effettiva del log
    // Esempio: scrive il messaggio del log su un file o console
    System.out.println(event.getMessage());
}