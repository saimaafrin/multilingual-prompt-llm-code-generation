import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.Filter;

public class FilterDecider {

    /**
     * Restituisce {@link Filter#NEUTRAL} se non c'è corrispondenza con la stringa.
     */
    public int decide(LoggingEvent event) {
        // Implementazione della logica per decidere il filtro
        // Se non c'è corrispondenza con la stringa, restituisce Filter.NEUTRAL
        // Qui si può aggiungere la logica per la corrispondenza della stringa
        return Filter.NEUTRAL;
    }
}