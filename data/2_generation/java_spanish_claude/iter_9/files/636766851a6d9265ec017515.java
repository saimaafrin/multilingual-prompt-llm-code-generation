import org.atmosphere.cpr.Action;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceImpl;
import org.atmosphere.cpr.AtmosphereInterceptor;

public class TransportInterceptor implements AtmosphereInterceptor {

    @Override
    public Action inspect(AtmosphereResource r) {
        if (r != null && r.transport() != null) {
            switch (r.transport()) {
                case WEBSOCKET:
                case STREAMING:
                case SSE:
                    r.suspend();
                    break;
                default:
                    break;
            }
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
}