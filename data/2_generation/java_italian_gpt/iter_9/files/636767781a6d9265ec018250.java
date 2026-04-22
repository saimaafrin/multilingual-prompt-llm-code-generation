import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.Filter;

public class FilterDecider {

    /**
     * Restituisce {@link Filter#NEUTRAL} se non c'è corrispondenza con la stringa.
     */
    public int decide(LoggingEvent event) {
        // Implementazione della logica per decidere se c'è corrispondenza
        // con la stringa. Se non c'è corrispondenza, restituisce Filter.NEUTRAL.
        
        // Esempio di logica: controlla se il messaggio dell'evento è vuoto
        if (event.getMessage() == null || event.getMessage().isEmpty()) {
            return Filter.NEUTRAL;
        }
        
        // Altrimenti, puoi implementare altre logiche di corrispondenza qui.
        
        // Restituisce un valore di default se non ci sono corrispondenze
        return Filter.NEUTRAL;
    }
}