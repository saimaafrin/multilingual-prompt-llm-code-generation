import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.Filter;

public class DecisionMaker {

    /** 
     * Returns  {@link Filter#NEUTRAL} is there is no string match.
     */
    public int decide(LoggingEvent event) {
        // Assuming we are checking for a specific string match in the LoggingEvent
        String message = event.getRenderedMessage();
        String targetString = "specificString"; // Replace with the actual string to match

        if (message != null && message.contains(targetString)) {
            // If there is a match, return a different filter value (e.g., Filter.ACCEPT)
            return Filter.ACCEPT;
        }
        
        // If there is no match, return Filter.NEUTRAL
        return Filter.NEUTRAL;
    }
}