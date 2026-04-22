import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResource.TRANSPORT;
import org.atmosphere.cpr.Action;

public class AtmosphereResourceInspector {

    /**
     * {@link AtmosphereResource} को {@link AtmosphereResource.TRANSPORT} मान के आधार पर स्वचालित रूप से निलंबित करें।
     * @param r एक {@link AtmosphereResource}
     * @return {@link Action#CONTINUE}
     */
    @Override
    public Action inspect(AtmosphereResource r) {
        if (r != null && r.transport() == TRANSPORT.WEBSOCKET) {
            r.suspend();
        }
        return Action.CONTINUE;
    }
}