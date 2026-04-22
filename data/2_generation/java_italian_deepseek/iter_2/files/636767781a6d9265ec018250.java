import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.Filter;

public class MyFilter {
    public int decide(LoggingEvent event) {
        // Implementazione di esempio: restituisce Filter.NEUTRAL se non c'è corrispondenza con la stringa
        String message = event.getMessage().toString();
        if (!message.contains("specific string")) {
            return Filter.NEUTRAL;
        }
        // Altrimenti, restituisci un altro valore di filtro appropriato
        return Filter.ACCEPT; // o Filter.DENY
    }
}