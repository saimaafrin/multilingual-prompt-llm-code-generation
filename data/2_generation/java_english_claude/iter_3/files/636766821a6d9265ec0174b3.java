import javax.servlet.ServletContext;
import org.eclipse.jetty.websocket.api.Session;

public class BroadcastFilterHandler {

    private BroadcastFilter filter;
    private ServletContext context;

    public BroadcastFilterHandler(BroadcastFilter filter, ServletContext context) {
        this.filter = filter;
        this.context = context;
    }

    /** 
     * Invoke the {@link BroadcastFilter}
     * @param msg The message to be filtered
     * @return The filtered message object
     */
    protected Object filter(Object msg) {
        if (filter == null || msg == null) {
            return msg;
        }
        
        try {
            return filter.filter(msg);
        } catch (Exception e) {
            // Log error but don't throw to avoid breaking broadcast chain
            context.log("Error in broadcast filter", e);
            return msg;
        }
    }
}