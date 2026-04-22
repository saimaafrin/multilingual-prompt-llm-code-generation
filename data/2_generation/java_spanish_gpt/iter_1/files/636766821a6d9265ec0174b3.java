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
            // For example, you might want to check if the message passes certain criteria
            if (filter instanceof String && msg instanceof String) {
                String filterStr = (String) filter;
                String msgStr = (String) msg;
                if (msgStr.contains(filterStr)) {
                    return msg; // Return the message if it passes the filter
                }
            }
        }
        return null; // Return null if no filters matched
    }

    public void addFilter(Object filter) {
        filters.add(filter);
    }

    public static void main(String[] args) {
        BroadcastFilter broadcastFilter = new BroadcastFilter();
        broadcastFilter.addFilter("test");
        
        Object result = broadcastFilter.filter("this is a test message");
        System.out.println(result); // Should print the message if it contains "test"
    }
}