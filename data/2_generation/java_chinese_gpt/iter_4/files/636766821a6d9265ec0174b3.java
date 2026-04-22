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
            // Assuming each filter has a method called apply that takes an Object and returns an Object
            msg = applyFilter(filter, msg);
        }
        return msg;
    }

    private Object applyFilter(Object filter, Object msg) {
        // Placeholder for filter application logic
        // This should be replaced with actual filter logic
        return msg; // Return the message unmodified for now
    }

    public void addFilter(Object filter) {
        filters.add(filter);
    }
}