import javax.websocket.Session;
import java.util.Set;

public class BroadcastManager {

    private Set<Session> sessions;
    private BroadcastFilter filter;

    public String invokeBroadcastFilter(String msg) {
        if (filter != null) {
            return filter.filter(msg);
        }
        return msg;
    }

    // Interface for broadcast filter
    public interface BroadcastFilter {
        String filter(String message);
    }

    // Constructor and other methods
    public BroadcastManager(Set<Session> sessions) {
        this.sessions = sessions;
    }

    public void setBroadcastFilter(BroadcastFilter filter) {
        this.filter = filter;
    }
}