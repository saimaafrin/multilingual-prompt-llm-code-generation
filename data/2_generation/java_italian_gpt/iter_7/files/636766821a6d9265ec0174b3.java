import java.util.ArrayList;
import java.util.List;

public class BroadcastFilterExample {

    private List<Object> filters = new ArrayList<>();

    /** 
     * Invoca il {@link BroadcastFilter}
     * @param msg
     * @return
     */
    protected Object filter(Object msg) {
        for (Object filter : filters) {
            // Assuming filter is a functional interface with a method apply
            if (filter instanceof Filter) {
                msg = ((Filter) filter).apply(msg);
            }
        }
        return msg;
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public interface Filter {
        Object apply(Object msg);
    }

    public static void main(String[] args) {
        BroadcastFilterExample example = new BroadcastFilterExample();
        
        // Example filter that converts message to uppercase
        example.addFilter(msg -> ((String) msg).toUpperCase());
        
        Object result = example.filter("hello world");
        System.out.println(result); // Output: HELLO WORLD
    }
}