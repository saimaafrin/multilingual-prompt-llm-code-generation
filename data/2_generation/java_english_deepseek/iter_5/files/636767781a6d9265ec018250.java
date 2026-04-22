import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter {
    /**
     * Returns {@link Filter#NEUTRAL} if there is no string match.
     */
    public int decide(LoggingEvent event) {
        // Assuming you want to check for a specific string in the event's message
        String message = event.getMessage().toString();
        
        // Replace "your_string_to_match" with the actual string you want to match
        if (!message.contains("your_string_to_match")) {
            return Filter.NEUTRAL;
        }
        
        // If there is a match, return Filter.ACCEPT or Filter.DENY based on your logic
        return Filter.ACCEPT; // or return Filter.DENY;
    }
}