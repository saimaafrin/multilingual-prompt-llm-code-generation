import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Action;

public class AtmosphereResourceInspector {

    /**
     * Automatically suspend the {@link AtmosphereResource} based on {@link AtmosphereResource.TRANSPORT} value.
     * @param r a {@link AtmosphereResource}
     * @return {@link Action#CONTINUE}
     */
    @Override 
    public Action inspect(AtmosphereResource r) {
        if (r.getTransport() != null) {
            // Logic to suspend the resource based on transport type
            // For example, if the transport is WebSocket, we might want to suspend it
            if (r.getTransport().equals(AtmosphereResource.TRANSPORT.WEBSOCKET)) {
                r.suspend();
            }
        }
        return Action.CONTINUE;
    }
}