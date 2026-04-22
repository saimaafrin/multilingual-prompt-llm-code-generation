import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.Filter;

public class FilterDecider {

    /**
     * Restituisce {@link Filter#NEUTRAL} se non c'è corrispondenza con la stringa.
     */
    public int decide(LoggingEvent event) {
        // Implementazione della logica per decidere se c'è corrispondenza
        // con la stringa. Se non c'è corrispondenza, restituisce Filter.NEUTRAL.
        
        // Esempio di logica di confronto (da personalizzare in base alle necessità)
        String message = event.getMessage();
        String searchString = "corrispondenza"; // Stringa da cercare

        if (message == null || !message.contains(searchString)) {
            return Filter.NEUTRAL;
        }

        // Altre logiche di filtro possono essere implementate qui
        return Filter.ACCEPT; // Restituisce un valore di esempio se c'è corrispondenza
    }
}