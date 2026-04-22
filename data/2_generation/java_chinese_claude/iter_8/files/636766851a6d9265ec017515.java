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
            case SSE:
            case STREAMING:
                r.suspend();
                break;
            case LONG_POLLING:
                r.suspend(r.getAtmosphereConfig().getInitParameter("maxLongPollTimeout", 30000));
                break;
            default:
                break;
        }
        
        return Action.CONTINUE;
    }
}