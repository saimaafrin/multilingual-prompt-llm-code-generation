import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Action;

public class MyAtmosphereHandler {

    /**
     * {@link AtmosphereResource} को {@link AtmosphereResource.TRANSPORT} मान के आधार पर स्वचालित रूप से निलंबित करें।
     * @param r एक {@link AtmosphereResource}
     * @return {@link Action#CONTINUE}
     */
    @Override
    public Action inspect(AtmosphereResource r) {
        // Check the transport type of the AtmosphereResource
        if (r.transport() == AtmosphereResource.TRANSPORT.WEBSOCKET) {
            // Perform any necessary actions for WebSocket transport
            // For example, you might want to suspend the resource
            r.suspend();
        } else if (r.transport() == AtmosphereResource.TRANSPORT.STREAMING) {
            // Handle streaming transport if needed
            r.suspend();
        }
        // Continue processing
        return Action.CONTINUE;
    }
}