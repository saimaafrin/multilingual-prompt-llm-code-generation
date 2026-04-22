import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.support.processor.DelegatingProcessor;

public class BroadcastFilter extends DelegatingProcessor {

    /**
     * Invoke the  {@link BroadcastFilter}
     * @param msg
     * @return
     */
    protected Object filter(Object msg) {
        // Implement your filtering logic here
        if (msg instanceof String) {
            String message = (String) msg;
            // Example filter: only allow messages that contain "allowed"
            if (message.contains("allowed")) {
                return msg; // Return the message if it passes the filter
            }
        }
        return null; // Return null if the message does not pass the filter
    }
}