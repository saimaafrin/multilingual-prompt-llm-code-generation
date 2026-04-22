import java.util.function.Predicate;

/**
 * Invoca il {@link BroadcastFilter}
 * @param msg the message to be filtered
 * @return the filtered message or null if the message does not pass the filter
 */
protected Object filter(Object msg) {
    // Assuming BroadcastFilter is a Predicate that checks if the message should be broadcasted
    Predicate<Object> broadcastFilter = new BroadcastFilter();
    
    if (broadcastFilter.test(msg)) {
        return msg;
    } else {
        return null;
    }
}

// Assuming BroadcastFilter is a class that implements Predicate<Object>
class BroadcastFilter implements Predicate<Object> {
    @Override
    public boolean test(Object msg) {
        // Implement the filtering logic here
        // For example, return true if the message should be broadcasted, false otherwise
        return true; // Placeholder logic
    }
}