import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.Filter;

public class DecisionMaker {

    /** 
     * Returns  {@link Filter#NEUTRAL} is there is no string match.
     */
    public int decide(LoggingEvent event) {
        // Assuming we have a condition to check for string match
        String message = event.getRenderedMessage();
        String searchString = "match"; // Example string to match

        if (message == null || !message.contains(searchString)) {
            return Filter.NEUTRAL;
        }
        
        // Additional logic can be added here for other cases
        return Filter.ACCEPT; // Example return for matched case
    }
}