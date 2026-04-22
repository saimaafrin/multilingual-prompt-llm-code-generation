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
        if (r.getRequest().getHeader("Transport") != null) {
            // 这里可以添加根据 Transport 处理的逻辑
            // 例如：如果是某种特定的 Transport，执行挂起操作
        }
        // 返回继续的 Action
        return Action.CONTINUE;
    }
}