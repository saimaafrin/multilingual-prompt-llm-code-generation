import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Action;

public class MyAtmosphereResourceInspector {

    /**
     * Automatically suspend the {@link AtmosphereResource} based on {@link AtmosphereResource.TRANSPORT} value.
     * @param r a {@link AtmosphereResource}
     * @return {@link Action#CONTINUE}
     */
    @Override
    public Action inspect(AtmosphereResource r) {
        if (r.transport() == AtmosphereResource.TRANSPORT.WEBSOCKET) {
            // Logic to suspend the resource if needed
            r.suspend();
        }
        return Action.CONTINUE;
    }
}