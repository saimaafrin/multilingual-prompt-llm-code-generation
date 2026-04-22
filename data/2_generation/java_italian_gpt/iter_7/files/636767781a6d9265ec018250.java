import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.Filter;

public class FilterDecider {

    /**
     * Restituisce {@link Filter#NEUTRAL} se non c'è corrispondenza con la stringa.
     */
    public int decide(LoggingEvent event) {
        // Implementazione della logica per decidere il filtro
        // Se non c'è corrispondenza, restituisce Filter.NEUTRAL
        // Qui si può aggiungere la logica per verificare la corrispondenza
        // Ad esempio, controllando il messaggio dell'evento di logging

        String message = event.getMessage().toString();
        // Supponiamo di avere una stringa di confronto
        String comparisonString = "someCriteria";

        if (!message.contains(comparisonString)) {
            return Filter.NEUTRAL;
        }

        // Altrimenti, si può restituire un altro valore di filtro
        // Ad esempio, Filter.ACCEPT o Filter.DENY
        return Filter.ACCEPT; // o un altro valore a seconda della logica
    }
}