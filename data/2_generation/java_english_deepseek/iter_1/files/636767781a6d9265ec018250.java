import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter {
    /**
     * Returns {@link Filter#NEUTRAL} if there is no string match.
     */
    public int decide(LoggingEvent event) {
        // Assuming you want to check for a specific string in the message
        String message = event.getMessage().toString();
        String searchString = "specificString"; // Replace with the string you want to match

        if (message.contains(searchString)) {
            return Filter.ACCEPT; // or Filter.DENY, depending on your logic
        } else {
            return Filter.NEUTRAL;
        }
    }
}