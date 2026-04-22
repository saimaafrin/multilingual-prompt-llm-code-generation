import java.util.ArrayList;
import java.util.List;

public class BroadcastFilterExample {

    private List<Object> filters;

    public BroadcastFilterExample() {
        filters = new ArrayList<>();
    }

    /** 
     * Invoca il {@link BroadcastFilter}
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
        // Placeholder for filter logic
        // In a real implementation, this would invoke the filter's logic
        return msg; // Return the message unmodified for this example
    }

    public void addFilter(Object filter) {
        filters.add(filter);
    }

    public static void main(String[] args) {
        BroadcastFilterExample example = new BroadcastFilterExample();
        example.addFilter(new Object()); // Add a filter for demonstration
        Object result = example.filter("Test Message");
        System.out.println(result);
    }
}