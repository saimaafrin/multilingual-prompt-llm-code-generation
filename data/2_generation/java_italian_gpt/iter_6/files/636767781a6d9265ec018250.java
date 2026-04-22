import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.Filter;

public class FilterDecider {

    /**
     * Restituisce {@link Filter#NEUTRAL} se non c'è corrispondenza con la stringa.
     */
    public int decide(LoggingEvent event) {
        // Implementazione della logica per decidere il filtro
        String message = event.getRenderedMessage();
        String searchString = "corrispondenza"; // Stringa da cercare

        if (message == null || !message.contains(searchString)) {
            return Filter.NEUTRAL; // Nessuna corrispondenza
        }

        // Logica aggiuntiva per altre decisioni può essere aggiunta qui
        return Filter.ACCEPT; // Esempio di accettazione se c'è corrispondenza
    }
}