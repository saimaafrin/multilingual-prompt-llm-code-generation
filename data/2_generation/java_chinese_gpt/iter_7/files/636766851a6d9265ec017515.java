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
        // 根据传输类型进行处理
        if (r.transport() == AtmosphereResource.TRANSPORT.WEBSOCKET) {
            // 处理 WebSocket 传输
            // 这里可以添加具体的逻辑
        } else if (r.transport() == AtmosphereResource.TRANSPORT.STREAMING) {
            // 处理流式传输
            // 这里可以添加具体的逻辑
        } else {
            // 处理其他类型的传输
            // 这里可以添加具体的逻辑
        }
        
        // 返回继续的动作
        return Action.CONTINUE;
    }
}