import org.atmosphere.cpr.Action;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceImpl;
import org.atmosphere.cpr.AtmosphereHandler;
import org.atmosphere.cpr.AtmosphereInterceptorAdapter;

public class TransportInterceptor extends AtmosphereInterceptorAdapter {
    
    @Override
    public Action inspect(AtmosphereResource r) {
        AtmosphereResource.TRANSPORT transport = r.transport();
        
        switch (transport) {
            case WEBSOCKET:
                // WebSocket connections are automatically suspended
                break;
            case SSE:
            case STREAMING:
            case LONG_POLLING:
                if (!r.isSuspended()) {
                    r.suspend();
                }
                break;
            default:
                // For other transports, no suspension needed
                break;
        }
        
        return Action.CONTINUE;
    }
}