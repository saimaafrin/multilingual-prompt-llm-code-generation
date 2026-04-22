import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.Filter;

public class DecisionMaker {

    /** 
     * Returns {@link Filter#NEUTRAL} if there is no string match.
     */
    public int decide(LoggingEvent event) {
        // Assuming we are checking for a specific string match in the message
        String message = event.getMessage().toString();
        String targetString = "match"; // Example target string

        if (!message.contains(targetString)) {
            return Filter.NEUTRAL;
        }
        
        // Additional logic can be added here for other conditions
        return Filter.ACCEPT; // Assuming we accept if there's a match
    }
}