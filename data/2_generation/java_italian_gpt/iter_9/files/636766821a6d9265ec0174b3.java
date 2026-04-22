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
        // Example filter logic
        for (Object filter : filters) {
            // Assuming filter is a functional interface that takes an Object and returns a boolean
            if (filter instanceof Filter) {
                if (!((Filter) filter).apply(msg)) {
                    return null; // Message filtered out
                }
            }
        }
        return msg; // Message passed all filters
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public interface Filter {
        boolean apply(Object msg);
    }

    public static void main(String[] args) {
        BroadcastFilterExample example = new BroadcastFilterExample();
        
        // Adding a simple filter that filters out null messages
        example.addFilter(msg -> msg != null);
        
        Object result = example.filter("Hello, World!");
        System.out.println(result); // Should print "Hello, World!"
        
        result = example.filter(null);
        System.out.println(result); // Should print "null"
    }
}