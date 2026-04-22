import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.Filter;

public class LogEventFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        if (event == null) {
            return Filter.NEUTRAL;
        }
        
        String message = event.getRenderedMessage();
        if (message == null || message.isEmpty()) {
            return Filter.NEUTRAL;
        }
        
        // Default implementation returns NEUTRAL if no match
        return Filter.NEUTRAL;
    }
}