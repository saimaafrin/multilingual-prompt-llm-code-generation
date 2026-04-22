import org.atmosphere.cpr.Action;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceImpl;
import org.atmosphere.cpr.AtmosphereHandler;
import org.atmosphere.cpr.AtmosphereInterceptorAdapter;

public class TransportInterceptor extends AtmosphereInterceptorAdapter {
    
    @Override 
    public Action inspect(AtmosphereResource r) {
        // Get the transport type
        AtmosphereResource.TRANSPORT transport = r.transport();
        
        // Suspend the resource based on transport type
        switch (transport) {
            case WEBSOCKET:
                // For WebSocket, suspend indefinitely
                r.suspend();
                break;
                
            case SSE:
            case STREAMING:
                // For Server-Sent Events and Streaming, suspend with a long timeout
                r.suspend(-1L);
                break;
                
            case LONG_POLLING:
                // For Long-Polling, suspend with a timeout
                r.suspend(30000); // 30 seconds timeout
                break;
                
            default:
                // For other transports, don't suspend
                break;
        }
        
        return Action.CONTINUE;
    }
}