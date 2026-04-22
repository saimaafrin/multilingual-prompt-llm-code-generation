import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Assuming you want to check if the message contains a specific string
        String message = event.getMessage().toString();
        String searchString = "specificString"; // Replace with the string you want to match

        if (message.contains(searchString)) {
            return Filter.ACCEPT; // or Filter.DENY based on your requirement
        } else {
            return Filter.NEUTRAL;
        }
    }
}