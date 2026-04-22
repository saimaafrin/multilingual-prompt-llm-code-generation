import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Assuming we are checking for a specific string in the log message
        String logMessage = event.getRenderedMessage();
        String searchString = "specificString"; // Replace with the actual string to match

        if (logMessage != null && logMessage.contains(searchString)) {
            return Filter.ACCEPT; // or Filter.DENY based on your requirement
        } else {
            return Filter.NEUTRAL;
        }
    }
}