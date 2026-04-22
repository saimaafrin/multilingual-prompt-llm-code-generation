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
        // Check the transport type of the AtmosphereResource
        AtmosphereResource.TRANSPORT transport = r.transport();

        // Suspend the resource if the transport is not supported
        if (transport != AtmosphereResource.TRANSPORT.WEBSOCKET && 
            transport != AtmosphereResource.TRANSPORT.SSE) {
            r.suspend();
        }

        // Return CONTINUE to allow further processing
        return Action.CONTINUE;
    }
}