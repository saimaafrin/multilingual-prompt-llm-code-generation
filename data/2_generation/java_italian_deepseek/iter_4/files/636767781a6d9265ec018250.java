import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.Filter;

public class MyFilter {

    /**
     * Restituisce {@link Filter#NEUTRAL} se non c'è corrispondenza con la stringa.
     */
    public int decide(LoggingEvent event) {
        // Implementazione di esempio: restituisce NEUTRAL se non c'è corrispondenza
        return Filter.NEUTRAL;
    }
}