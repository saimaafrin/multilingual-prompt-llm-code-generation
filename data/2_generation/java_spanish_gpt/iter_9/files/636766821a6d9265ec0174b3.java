import java.util.ArrayList;
import java.util.List;

public class BroadcastFilter {

    private List<Object> filters;

    public BroadcastFilter() {
        this.filters = new ArrayList<>();
    }

    /**
     * Invoca el {@link BroadcastFilter}
     * @param msg
     * @return
     */
    protected Object filter(Object msg) {
        for (Object filter : filters) {
            // Apply each filter to the message
            // This is a placeholder for actual filter logic
            if (filter instanceof Filter) {
                msg = ((Filter) filter).apply(msg);
            }
        }
        return msg;
    }

    public void addFilter(Object filter) {
        filters.add(filter);
    }

    interface Filter {
        Object apply(Object msg);
    }
}