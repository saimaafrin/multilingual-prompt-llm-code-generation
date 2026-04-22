import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class LogFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        if (event == null || event.getMessage() == null) {
            return Filter.NEUTRAL;
        }

        String message = event.getMessage().toString();
        
        // Since no string matching criteria is specified in requirements
        // Always return NEUTRAL as default behavior
        return Filter.NEUTRAL;
    }
}