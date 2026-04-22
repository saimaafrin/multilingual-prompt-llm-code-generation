import org.apache.log4j.spi.LoggingEvent;

public class Filter {
    public static final int NEUTRAL = 0;

    public int decide(LoggingEvent event) {
        // Implementazione di esempio: restituisce NEUTRAL se non c'è corrispondenza con la stringa
        return NEUTRAL;
    }
}