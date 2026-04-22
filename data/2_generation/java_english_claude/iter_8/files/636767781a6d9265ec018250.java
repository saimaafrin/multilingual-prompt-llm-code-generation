import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.Filter;

public class LoggingFilter extends Filter {

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