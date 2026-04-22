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
        formattedEvent.append("[").append(event.getTimeStamp()).append("] ");
        
        // Aggiungi il livello di logging
        formattedEvent.append("[").append(event.getLevel().toString()).append("] ");
        
        // Aggiungi il nome del logger
        formattedEvent.append("[").append(event.getLoggerName()).append("] ");
        
        // Aggiungi il messaggio di logging
        formattedEvent.append(event.getRenderedMessage());
        
        // Aggiungi l'eventuale stack trace se presente
        String[] throwableStrRep = event.getThrowableStrRep();
        if (throwableStrRep != null) {
            formattedEvent.append("\n");
            for (String line : throwableStrRep) {
                formattedEvent.append(line).append("\n");
            }
        }
        
        return formattedEvent.toString();
    }
}