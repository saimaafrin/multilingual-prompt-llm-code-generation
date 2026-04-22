import org.apache.log4j.spi.LoggingEvent;

/**
 * Questo metodo esegue la scrittura effettiva
 */
protected void subAppend(LoggingEvent event) {
    // Implementazione della scrittura effettiva del log
    // Ad esempio, potrebbe scrivere su un file, console, o altro output
    System.out.println(event.getMessage());
}