import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Assuming the logic to decide is based on some condition
        // For example, if the message contains a specific string
        String message = event.getRenderedMessage();
        if (message != null && message.contains("specific_string")) {
            return Filter.ACCEPT; // or Filter.DENY based on your logic
        } else {
            return Filter.NEUTRAL;
        }
    }
}