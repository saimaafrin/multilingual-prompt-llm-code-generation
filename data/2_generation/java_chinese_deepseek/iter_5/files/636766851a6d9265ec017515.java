import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResource.TRANSPORT;
import org.atmosphere.cpr.Action;

public class AtmosphereInspector {

    /**
     * 根据 {@link AtmosphereResource.TRANSPORT} 的值自动挂起 {@link AtmosphereResource}。
     * @param r 一个 {@link AtmosphereResource}
     * @return {@link Action#CONTINUE}
     */
    @Override
    public Action inspect(AtmosphereResource r) {
        TRANSPORT transport = r.transport();
        if (transport == TRANSPORT.WEBSOCKET || transport == TRANSPORT.STREAMING) {
            r.suspend();
        }
        return Action.CONTINUE;
    }
}