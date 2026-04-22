import javax.servlet.ServletContext;
import org.eclipse.jetty.websocket.api.Session;

public class BroadcastFilterImpl {

    private BroadcastFilter broadcastFilter;
    private ServletContext context;

    public BroadcastFilterImpl(BroadcastFilter filter, ServletContext servletContext) {
        this.broadcastFilter = filter;
        this.context = servletContext;
    }

    /** 
     * Invoke the {@link BroadcastFilter}
     * @param msg The message to be filtered
     * @return The filtered message object
     */
    protected Object filter(Object msg) {
        if (broadcastFilter == null) {
            return msg;
        }
        
        try {
            return broadcastFilter.filter(msg);
        } catch (Exception e) {
            // Log error and return original message if filter fails
            context.log("Broadcast filter error", e);
            return msg;
        }
    }
}