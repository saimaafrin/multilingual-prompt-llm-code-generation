import org.atmosphere.cpr.Action;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResource.TRANSPORT;

public class AtmosphereHandler {

    public Action suspend(AtmosphereResource r) {
        switch (r.transport()) {
            case JSONP:
            case LONG_POLLING:
                r.suspend(5000L); // 5 seconds timeout for polling transports
                break;
            case SSE:
            case WEBSOCKET:
                r.suspend(-1); // No timeout for streaming transports
                break;
            default:
                r.suspend(30000L); // 30 seconds default timeout
                break;
        }
        return Action.CONTINUE;
    }

}