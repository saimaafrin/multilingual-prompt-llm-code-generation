import java.util.Objects;

public class MessageFilter {
    private BroadcastFilter broadcastFilter;

    public MessageFilter(BroadcastFilter broadcastFilter) {
        this.broadcastFilter = Objects.requireNonNull(broadcastFilter);
    }

    /**
     * Invoca el {@link BroadcastFilter}
     * @param msg
     * @return
     */
    protected Object filter(Object msg) {
        if (msg == null) {
            return null;
        }
        
        try {
            return broadcastFilter.filter(msg);
        } catch (Exception e) {
            // Log error if needed
            return msg; // Return original message if filtering fails
        }
    }
}

// Interface definition for reference
interface BroadcastFilter {
    Object filter(Object message);
}