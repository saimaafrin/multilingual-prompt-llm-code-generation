import org.atmosphere.cpr.Action;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceImpl;
import org.atmosphere.cpr.AtmosphereHandler;
import org.atmosphere.cpr.AtmosphereResource.TRANSPORT;

public class AtmosphereResourceInspector implements AtmosphereHandler {

    @Override
    public Action inspect(AtmosphereResource r) {
        if (r == null) {
            return Action.CONTINUE;
        }

        switch (r.transport()) {
            case WEBSOCKET:
            case SSE:
            case STREAMING:
                r.suspend();
                break;
            case LONG_POLLING:
                r.suspend(r.getAtmosphereConfig().getPropertyValue("polling.timeout", 5000L));
                break;
            default:
                break;
        }

        return Action.CONTINUE;
    }

    @Override
    public void onRequest(AtmosphereResource resource) throws IOException {
        // Required by AtmosphereHandler interface
    }

    @Override 
    public void onStateChange(AtmosphereResourceEvent event) throws IOException {
        // Required by AtmosphereHandler interface
    }

    @Override
    public void destroy() {
        // Required by AtmosphereHandler interface
    }
}