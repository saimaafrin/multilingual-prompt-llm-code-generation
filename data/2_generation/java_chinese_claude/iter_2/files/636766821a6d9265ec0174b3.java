import java.util.ArrayList;
import java.util.List;

public class BroadcastHandler {
    
    private List<BroadcastFilter> filters;

    public BroadcastHandler() {
        this.filters = new ArrayList<>();
    }

    /**
     * 调用 {@link BroadcastFilter}
     * @param msg
     * @return
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