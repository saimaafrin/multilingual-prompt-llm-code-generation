import java.util.Objects;

/**
 * 调用 {@link BroadcastFilter}
 * @param msg 要过滤的消息
 * @return 过滤后的消息
 */
protected Object filter(Object msg) {
    // 假设 BroadcastFilter 是一个接口或类，这里我们假设它是一个接口
    // 并且有一个 filter 方法
    BroadcastFilter filter = new BroadcastFilterImpl(); // 假设有一个实现类
    return filter.filter(msg);
}

// 假设的 BroadcastFilter 接口
interface BroadcastFilter {
    Object filter(Object msg);
}

// 假设的 BroadcastFilter 实现类
class BroadcastFilterImpl implements BroadcastFilter {
    @Override
    public Object filter(Object msg) {
        // 这里可以实现具体的过滤逻辑
        // 例如，返回消息本身，或者根据某些条件进行过滤
        return msg;
    }
}