import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Assuming you want to check if the message contains a specific string
        String message = event.getRenderedMessage();
        if (message != null && message.contains("specificString")) {
            return Filter.ACCEPT; // or Filter.DENY based on your logic
        }
        return Filter.NEUTRAL;
    }
}