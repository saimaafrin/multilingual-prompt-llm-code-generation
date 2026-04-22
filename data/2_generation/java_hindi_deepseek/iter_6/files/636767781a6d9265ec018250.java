import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Assuming the logic to decide is based on some string matching
        // For example, if the message in the event does not match a certain pattern, return NEUTRAL
        String message = event.getMessage().toString();
        
        // Example condition: if the message does not contain "error", return NEUTRAL
        if (!message.contains("error")) {
            return Filter.NEUTRAL;
        }
        
        // Otherwise, return ACCEPT or DENY based on your logic
        return Filter.ACCEPT; // or Filter.DENY
    }
}