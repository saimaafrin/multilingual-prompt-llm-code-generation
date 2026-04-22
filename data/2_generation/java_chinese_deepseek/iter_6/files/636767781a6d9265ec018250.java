import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Assuming we are checking for a specific string in the log message
        String logMessage = event.getRenderedMessage();
        String targetString = "specificString"; // Replace with the actual string to match

        if (logMessage != null && logMessage.contains(targetString)) {
            return Filter.ACCEPT; // Return ACCEPT if the string is found
        } else {
            return Filter.NEUTRAL; // Return NEUTRAL if no match is found
        }
    }
}