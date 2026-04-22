import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    /**
     * Produce una stringa formattata come specificato dal modello di conversione.
     * 
     * @param event L'evento di log da formattare.
     * @return La stringa formattata.
     */
    public String format(LoggingEvent event) {
        // Esempio di formattazione: [Livello] Messaggio (Timestamp)
        String level = event.getLevel().toString();
        String message = event.getRenderedMessage();
        long timestamp = event.getTimeStamp();

        return String.format("[%s] %s (%d)", level, message, timestamp);
    }
}