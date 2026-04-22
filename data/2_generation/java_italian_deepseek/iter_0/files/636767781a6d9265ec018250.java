import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.Filter;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Implementazione della logica di decisione
        // Se non c'è corrispondenza con la stringa, restituisci Filter.NEUTRAL
        return Filter.NEUTRAL;
    }
}