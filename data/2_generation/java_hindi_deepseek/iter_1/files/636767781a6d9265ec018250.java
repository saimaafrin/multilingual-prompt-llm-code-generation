import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    /**
     * यदि कोई स्ट्रिंग मेल नहीं खाता है तो {@link Filter#NEUTRAL} लौटाता है।
     */
    @Override
    public int decide(LoggingEvent event) {
        // Implement your logic here
        // For example, check if the message matches a certain condition
        String message = event.getRenderedMessage();
        
        if (message != null && message.contains("specific_string")) {
            return Filter.ACCEPT; // or Filter.DENY based on your condition
        } else {
            return Filter.NEUTRAL;
        }
    }
}