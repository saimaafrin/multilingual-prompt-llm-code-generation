import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.Filter;

public class FilterDecider {

    /**
     * Restituisce {@link Filter#NEUTRAL} se non c'è corrispondenza con la stringa.
     */
    public int decide(LoggingEvent event) {
        // Implementazione della logica per decidere il filtro
        // Se non c'è corrispondenza con la stringa, restituisce Filter.NEUTRAL
        // Qui si può aggiungere la logica per la corrispondenza
        String message = event.getMessage().toString();
        
        // Esempio di logica di corrispondenza (da personalizzare)
        String searchString = "corrispondenza"; // Stringa da cercare
        if (!message.contains(searchString)) {
            return Filter.NEUTRAL;
        }
        
        // Altre logiche di filtro possono essere aggiunte qui
        return Filter.ACCEPT; // Restituisce un valore di esempio se c'è corrispondenza
    }
}