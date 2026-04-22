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
        
        return broadcastFilter.filter(msg);
    }
}

interface BroadcastFilter {
    Object filter(Object message);
}