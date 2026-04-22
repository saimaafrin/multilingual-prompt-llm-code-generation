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
        if (r.transport() == TRANSPORT.WEBSOCKET) {
            r.suspend();
        } else if (r.transport() == TRANSPORT.LONG_POLLING) {
            r.suspend(-1); // 挂起长轮询连接
        } else if (r.transport() == TRANSPORT.STREAMING) {
            r.suspend(-1); // 挂起流式连接
        }
        return Action.CONTINUE;
    }
}