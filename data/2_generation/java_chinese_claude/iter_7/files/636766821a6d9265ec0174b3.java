import java.util.ArrayList;
import java.util.List;

public class BroadcastHandler {

    private List<BroadcastFilter> filters;

    public BroadcastHandler() {
        this.filters = new ArrayList<>();
    }

    /**
     * 调用 {@link BroadcastFilter}
     * @param msg 需要过滤的消息对象
     * @return 过滤后的消息对象
     */
    protected Object filter(Object msg) {
        Object result = msg;
        if (filters != null && !filters.isEmpty()) {
            for (BroadcastFilter filter : filters) {
                result = filter.doFilter(result);
                if (result == null) {
                    break;
                }
            }
        }
        return result;
    }

    // Inner interface for filter implementation
    public interface BroadcastFilter {
        Object doFilter(Object msg);
    }
}