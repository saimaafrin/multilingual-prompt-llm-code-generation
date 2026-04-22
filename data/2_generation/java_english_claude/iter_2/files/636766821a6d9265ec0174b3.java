import javax.servlet.ServletContext;
import org.eclipse.jetty.websocket.api.Session;

public class BroadcastFilterHandler {

    private BroadcastFilter filter;
    private ServletContext context;

    public BroadcastFilterHandler(ServletContext context) {
        this.context = context;
        this.filter = new BroadcastFilter();
    }

    /**
     * Invoke the {@link BroadcastFilter}
     * @param msg Message to be filtered
     * @return Filtered message object
     */
    protected Object filter(Object msg) {
        if (filter == null || msg == null) {
            return msg;
        }

        try {
            return filter.filter(msg);
        } catch (Exception e) {
            // Log error and return original message if filter fails
            context.log("Error filtering broadcast message", e);
            return msg;
        }
    }
}