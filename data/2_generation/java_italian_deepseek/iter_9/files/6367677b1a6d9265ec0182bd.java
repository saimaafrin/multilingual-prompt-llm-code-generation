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
        formattedEvent.append(event.getTimeStamp()).append(" ");
        
        // Aggiungi il livello di log
        formattedEvent.append(event.getLevel().toString()).append(" ");
        
        // Aggiungi il nome del logger
        formattedEvent.append(event.getLoggerName()).append(" ");
        
        // Aggiungi il messaggio di log
        formattedEvent.append(event.getRenderedMessage());
        
        // Se ci sono informazioni di throwable, aggiungile
        if (event.getThrowableInformation() != null) {
            formattedEvent.append("\n").append(event.getThrowableStrRep());
        }
        
        return formattedEvent.toString();
    }
}