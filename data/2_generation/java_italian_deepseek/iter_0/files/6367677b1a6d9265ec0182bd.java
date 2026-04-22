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
        formattedEvent.append("Timestamp: ").append(event.getTimeStamp()).append(" ");
        
        // Aggiungi il livello di log
        formattedEvent.append("Level: ").append(event.getLevel().toString()).append(" ");
        
        // Aggiungi il messaggio di log
        formattedEvent.append("Message: ").append(event.getMessage()).append(" ");
        
        // Aggiungi il nome del logger
        formattedEvent.append("Logger: ").append(event.getLoggerName()).append(" ");
        
        // Aggiungi il thread name
        formattedEvent.append("Thread: ").append(event.getThreadName()).append(" ");
        
        // Aggiungi l'eccezione se presente
        if (event.getThrowableInformation() != null) {
            formattedEvent.append("Exception: ").append(event.getThrowableInformation().getThrowable().toString()).append(" ");
        }
        
        return formattedEvent.toString();
    }
}