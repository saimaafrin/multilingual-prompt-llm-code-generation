import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

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
        
        return Filter.NEUTRAL;
    }
}