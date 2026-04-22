import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * Formatta un evento di logging per un writer.
     * @param event evento di logging da formattare.
     * @return la stringa formattata rappresentante l'evento di logging.
     */
    public String format(final LoggingEvent event) {
        StringBuilder formattedMessage = new StringBuilder();

        // Aggiungi il timestamp
        formattedMessage.append("[").append(event.getTimeStamp()).append("] ");

        // Aggiungi il livello di logging
        formattedMessage.append("[").append(event.getLevel().toString()).append("] ");

        // Aggiungi il nome del logger
        formattedMessage.append("[").append(event.getLoggerName()).append("] ");

        // Aggiungi il messaggio di log
        formattedMessage.append(event.getRenderedMessage());

        // Aggiungi l'eventuale stack trace se presente
        String[] throwableStrRep = event.getThrowableStrRep();
        if (throwableStrRep != null) {
            formattedMessage.append("\n");
            for (String line : throwableStrRep) {
                formattedMessage.append(line).append("\n");
            }
        }

        return formattedMessage.toString();
    }
}