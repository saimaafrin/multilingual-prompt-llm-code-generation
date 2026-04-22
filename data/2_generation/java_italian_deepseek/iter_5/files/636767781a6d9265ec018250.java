import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.Filter;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Implementazione di esempio: restituisce NEUTRAL se non c'è corrispondenza con la stringa
        String message = event.getMessage().toString();
        if (!message.contains("specific string")) {
            return Filter.NEUTRAL;
        } else {
            return Filter.ACCEPT; // o Filter.DENY, a seconda della logica
        }
    }
}