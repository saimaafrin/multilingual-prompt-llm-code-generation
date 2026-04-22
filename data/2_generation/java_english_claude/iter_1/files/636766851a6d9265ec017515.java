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
                // These transports require suspension
                r.suspend();
                break;
            case LONG_POLLING:
                // Long polling handled separately
                if (!r.getRequest().getHeader("Connection", "").equalsIgnoreCase("close")) {
                    r.suspend();
                }
                break;
            default:
                // Other transports don't require suspension
                break;
        }
        
        return Action.CONTINUE;
    }

    @Override
    public void postInspect(AtmosphereResource r) {
        // No post-inspection needed
    }

    @Override
    public void destroy() {
        // No resources to clean up
    }
}