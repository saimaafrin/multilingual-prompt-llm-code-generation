import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Implementazione di esempio: restituisce NEUTRAL se non c'è corrispondenza con la stringa
        String message = event.getMessage().toString();
        if (!message.contains("specific string")) {
            return Filter.NEUTRAL;
        }
        // Altrimenti, restituisce ACCEPT o DENY in base alla logica specifica
        return Filter.ACCEPT; // o Filter.DENY
    }
}