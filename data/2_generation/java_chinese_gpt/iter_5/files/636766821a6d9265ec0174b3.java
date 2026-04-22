import java.util.ArrayList;
import java.util.List;

public class BroadcastFilter {

    private List<Object> filters;

    public BroadcastFilter() {
        this.filters = new ArrayList<>();
    }

    /**
     * 调用 {@link BroadcastFilter}
     * @param msg
     * @return
     */
    protected Object filter(Object msg) {
        for (Object filter : filters) {
            // Assuming filter is a functional interface that takes an Object and returns an Object
            msg = applyFilter(filter, msg);
        }
        return msg;
    }

    private Object applyFilter(Object filter, Object msg) {
        // Implement the logic to apply the filter to the message
        // This is a placeholder for the actual filter application logic
        return msg; // Return the modified message after applying the filter
    }

    public void addFilter(Object filter) {
        filters.add(filter);
    }
}