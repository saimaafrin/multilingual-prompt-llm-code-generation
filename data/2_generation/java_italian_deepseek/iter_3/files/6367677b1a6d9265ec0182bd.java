import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * Formatta un evento di logging per un writer.
     * @param event evento di logging da formattare.
     * @return la stringa formattata rappresentante l'evento di logging.
     */
    public String format(final LoggingEvent event) {
        StringBuilder formattedEvent = new StringBuilder();
        
        // Aggiungi il timestamp
        formattedEvent.append("Timestamp: ").append(event.getTimeStamp()).append("\n");
        
        // Aggiungi il livello di log
        formattedEvent.append("Level: ").append(event.getLevel().toString()).append("\n");
        
        // Aggiungi il messaggio di log
        formattedEvent.append("Message: ").append(event.getRenderedMessage()).append("\n");
        
        // Aggiungi il logger name
        formattedEvent.append("Logger: ").append(event.getLoggerName()).append("\n");
        
        // Aggiungi il thread name
        formattedEvent.append("Thread: ").append(event.getThreadName()).append("\n");
        
        // Aggiungi l'eccezione, se presente
        if (event.getThrowableStrRep() != null) {
            formattedEvent.append("Exception: ");
            for (String line : event.getThrowableStrRep()) {
                formattedEvent.append(line).append("\n");
            }
        }
        
        return formattedEvent.toString();
    }
}