import org.apache.log4j.spi.LoggingEvent;

public class Filter {
    public static final int NEUTRAL = 0;

    public int decide(LoggingEvent event) {
        // Implementazione di esempio: restituisce NEUTRAL se non c'è corrispondenza con la stringa
        String message = event.getMessage().toString();
        if (!message.contains("specific string")) {
            return NEUTRAL;
        }
        // Altrimenti, restituisce un altro valore (ad esempio 1 per indicare una corrispondenza)
        return 1;
    }
}