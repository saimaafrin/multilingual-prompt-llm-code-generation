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

        // Add any specific filtering logic here
        // For now just returns NEUTRAL as per docstring
        return Filter.NEUTRAL;
    }
}