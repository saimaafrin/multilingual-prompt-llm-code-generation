import org.apache.log4j.spi.LoggingEvent;

/**
 * Este método realiza la escritura
 */
protected void subAppend(LoggingEvent event) {
    // Aquí se implementaría la lógica para escribir el evento de logging
    // Por ejemplo, escribir en un archivo, consola, etc.
    // Este es un ejemplo básico que imprime el mensaje del evento en la consola
    System.out.println(event.getMessage());
}