import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Assuming the logic to decide is based on some string comparison
        String message = event.getMessage().toString();
        
        // Example condition: if the message does not match a specific string, return NEUTRAL
        if (!message.equals("expectedString")) {
            return Filter.NEUTRAL;
        }
        
        // Otherwise, return ACCEPT or DENY based on your logic
        return Filter.ACCEPT; // or Filter.DENY
    }
}