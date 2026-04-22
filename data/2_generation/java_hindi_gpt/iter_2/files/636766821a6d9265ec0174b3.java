import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class BroadcastFilter implements Processor {

    /**
     * {@link BroadcastFilter} को कॉल करें
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

    @Override
    public void process(Exchange exchange) throws Exception {
        Object msg = exchange.getIn().getBody();
        Object filteredMsg = filter(msg);
        if (filteredMsg != null) {
            exchange.getIn().setBody(filteredMsg);
        } else {
            exchange.getIn().setBody("Message filtered out");
        }
    }
}