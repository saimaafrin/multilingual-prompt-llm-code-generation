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
                // For Server-Sent Events and Streaming, suspend with timeout
                r.suspend(5000); // 5 second timeout
                break;
                
            case LONG_POLLING:
                // For Long-Polling, suspend with shorter timeout
                r.suspend(30000); // 30 second timeout
                break;
                
            default:
                // For other transports, use default suspension
                r.suspend();
                break;
        }
        
        return Action.CONTINUE;
    }
}