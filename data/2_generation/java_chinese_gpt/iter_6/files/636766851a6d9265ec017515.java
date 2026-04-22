import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Action;

public class MyAtmosphereHandler {

    /**
     * 根据 {@link AtmosphereResource.TRANSPORT} 的值自动挂起 {@link AtmosphereResource}。
     * @param r 一个 {@link AtmosphereResource}
     * @return {@link Action#CONTINUE}
     */
    @Override
    public Action inspect(AtmosphereResource r) {
        // 根据 TRANSPORT 的值进行处理
        if (r.getTransport() != null) {
            // 这里可以添加根据不同 TRANSPORT 类型的逻辑
            // 例如：如果是 WebSocket，执行某些操作
        }
        // 返回继续的 Action
        return Action.CONTINUE;
    }
}