import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter {
    /**
     * Returns {@link Filter#NEUTRAL} if there is no string match.
     */
    public int decide(LoggingEvent event) {
        // Assuming we are checking for a specific string in the message
        String message = event.getMessage().toString();
        String targetString = "specificString"; // Replace with the actual string to match

        if (message.contains(targetString)) {
            return Filter.ACCEPT; // or Filter.DENY, depending on your logic
        } else {
            return Filter.NEUTRAL;
        }
    }
}