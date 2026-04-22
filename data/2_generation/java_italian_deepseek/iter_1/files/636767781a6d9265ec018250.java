import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.Filter;

public class MyFilter extends Filter {

    /**
     * Restituisce {@link Filter#NEUTRAL} se non c'è corrispondenza con la stringa.
     */
    @Override
    public int decide(LoggingEvent event) {
        // Implementazione di esempio: restituisce NEUTRAL se non c'è corrispondenza con la stringa
        String message = event.getRenderedMessage();
        if (message == null || !message.contains("specific string")) {
            return Filter.NEUTRAL;
        }
        // Altrimenti, restituisce ACCEPT o DENY in base alla logica specifica
        return Filter.ACCEPT; // o Filter.DENY
    }
}