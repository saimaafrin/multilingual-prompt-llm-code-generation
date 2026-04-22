import org.atmosphere.cpr.Action;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceImpl;
import org.atmosphere.cpr.AtmosphereInterceptor;

public class TransportInterceptor implements AtmosphereInterceptor {

    @Override
    public Action inspect(AtmosphereResource r) {
        if (r != null && r.transport().equals(AtmosphereResource.TRANSPORT.WEBSOCKET)) {
            AtmosphereResourceImpl.class.cast(r).suspend();
        }
        return Action.CONTINUE;
    }

    @Override
    public void postInspect(AtmosphereResource r) {
        // No implementation needed
    }

    @Override
    public void destroy() {
        // No implementation needed
    }

    @Override
    public void configure(org.atmosphere.cpr.AtmosphereConfig config) {
        // No implementation needed
    }
}