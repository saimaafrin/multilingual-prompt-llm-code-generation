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
            r.suspend(-1); // Suspend indefinitely for long polling
        } else {
            // For other transports, continue without suspending
        }
        return Action.CONTINUE;
    }
}