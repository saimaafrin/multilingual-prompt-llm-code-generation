import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class LogEventFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        if (event == null) {
            return Filter.NEUTRAL;
        }
        
        // Since no string matching is needed according to docstring,
        // always return NEUTRAL
        return Filter.NEUTRAL;
    }
}