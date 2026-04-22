import javax.websocket.Session;
import java.util.Set;

public class BroadcastManager {

    private Set<Session> sessions;
    private BroadcastFilter filter;

    public String broadcast(String msg) {
        if (filter != null) {
            msg = filter.filter(msg);
        }
        
        for (Session session : sessions) {
            if (session.isOpen()) {
                session.getAsyncRemote().sendText(msg);
            }
        }
        
        return msg;
    }
}

interface BroadcastFilter {
    String filter(String message);
}