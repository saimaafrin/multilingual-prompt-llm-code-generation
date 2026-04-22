import java.util.ArrayList;
import java.util.List;

public class BroadcastFilterExample {

    /**
     * Invoca el {@link BroadcastFilter}
     * @param msg
     * @return
     */
    protected Object filter(Object msg) {
        // Example implementation of a BroadcastFilter
        List<Object> filteredMessages = new ArrayList<>();
        
        // Simulate filtering logic
        if (msg instanceof String) {
            String message = (String) msg;
            if (!message.isEmpty()) {
                filteredMessages.add(message);
            }
        }
        
        return filteredMessages.isEmpty() ? null : filteredMessages;
    }

    public static void main(String[] args) {
        BroadcastFilterExample example = new BroadcastFilterExample();
        Object result = example.filter("Hello, World!");
        System.out.println(result);
    }
}