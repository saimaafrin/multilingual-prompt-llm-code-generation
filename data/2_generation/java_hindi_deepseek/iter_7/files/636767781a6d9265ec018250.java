import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Assuming the logic to decide is based on some string comparison
        // For example, checking if the message contains a specific string
        String message = event.getRenderedMessage();
        
        // Replace "specificString" with the actual string to match
        if (message != null && message.contains("specificString")) {
            return Filter.ACCEPT; // or Filter.DENY based on your logic
        } else {
            return Filter.NEUTRAL;
        }
    }
}