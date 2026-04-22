import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class CustomLoggingFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Return NEUTRAL if there is no string match
        return Filter.NEUTRAL;
    }

}