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
        // 根据传输类型挂起资源
        if (r.transport() != null) {
            // 这里可以添加根据不同传输类型的逻辑
            // 例如：如果是长轮询，则挂起
            if (r.transport().equals(AtmosphereResource.TRANSPORT.LONG_POLLING)) {
                r.suspend();
            }
        }
        return Action.CONTINUE;
    }
}