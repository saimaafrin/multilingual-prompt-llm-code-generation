import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Action;

public class AtmosphereResourceInspector {

    /**
     * Sospende automaticamente il {@link AtmosphereResource} in base al valore di {@link AtmosphereResource.TRANSPORT}.
     * @param r un {@link AtmosphereResource}
     * @return {@link Action#CONTINUE}
     */
    @Override
    public Action inspect(AtmosphereResource r) {
        // Check the transport type and suspend the resource if necessary
        if (r.transport() == AtmosphereResource.TRANSPORT.WEBSOCKET) {
            r.suspend();
        } else if (r.transport() == AtmosphereResource.TRANSPORT.LONG_POLLING) {
            r.suspend(-1); // Suspend indefinitely
        } else if (r.transport() == AtmosphereResource.TRANSPORT.STREAMING) {
            r.suspend(30000); // Suspend for 30 seconds
        }

        // Return Action.CONTINUE to allow further processing
        return Action.CONTINUE;
    }
}