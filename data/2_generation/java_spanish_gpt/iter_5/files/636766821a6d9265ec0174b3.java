import java.util.ArrayList;
import java.util.List;

public class BroadcastFilter {

    // List to hold the filtered messages
    private List<Object> filteredMessages = new ArrayList<>();

    /** 
     * Invoca el {@link BroadcastFilter}
     * @param msg
     * @return
     */
    protected Object filter(Object msg) {
        // Example filter logic: only allow non-null messages
        if (msg != null) {
            filteredMessages.add(msg);
            return msg; // Return the message if it passes the filter
        }
        return null; // Return null if the message is filtered out
    }

    // Method to get all filtered messages
    public List<Object> getFilteredMessages() {
        return filteredMessages;
    }

    public static void main(String[] args) {
        BroadcastFilter broadcastFilter = new BroadcastFilter();
        System.out.println(broadcastFilter.filter("Hello")); // Should print: Hello
        System.out.println(broadcastFilter.filter(null)); // Should print: null
        System.out.println(broadcastFilter.getFilteredMessages()); // Should print: [Hello]
    }
}