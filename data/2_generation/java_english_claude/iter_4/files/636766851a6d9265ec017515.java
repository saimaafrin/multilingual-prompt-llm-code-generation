import org.atmosphere.cpr.Action;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceImpl;
import org.atmosphere.cpr.AtmosphereHandler;
import org.atmosphere.cpr.AtmosphereInterceptor;

public class TransportInterceptor implements AtmosphereInterceptor {

    @Override
    public Action inspect(AtmosphereResource r) {
        AtmosphereResource.TRANSPORT transport = r.transport();
        
        switch (transport) {
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
    public void postInspect(AtmosphereResource r) {
        // No post inspection needed
    }

    @Override
    public void destroy() {
        // No cleanup needed
    }
}