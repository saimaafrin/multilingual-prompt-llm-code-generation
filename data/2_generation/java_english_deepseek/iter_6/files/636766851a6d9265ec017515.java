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
        if (r.transport() == AtmosphereResource.TRANSPORT.WEBSOCKET) {
            r.suspend();
        } else if (r.transport() == AtmosphereResource.TRANSPORT.LONG_POLLING) {
            r.suspend(-1); // Suspend indefinitely
        } else if (r.transport() == AtmosphereResource.TRANSPORT.POLLING) {
            r.suspend(30000); // Suspend for 30 seconds
        } else {
            // Default action for other transports
            r.suspend();
        }
        return Action.CONTINUE;
    }
}