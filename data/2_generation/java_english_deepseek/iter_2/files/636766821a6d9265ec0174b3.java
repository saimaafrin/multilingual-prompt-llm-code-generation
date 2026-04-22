import java.util.function.Predicate;

/**
 * Invoke the {@link BroadcastFilter}
 * @param msg The message to be filtered
 * @return The filtered message or null if the message is filtered out
 */
protected Object filter(Object msg) {
    // Assuming BroadcastFilter is a functional interface or a class with a test method
    // For example, let's assume BroadcastFilter is a Predicate<Object>
    Predicate<Object> broadcastFilter = new BroadcastFilter();

    if (broadcastFilter.test(msg)) {
        return msg; // Return the message if it passes the filter
    } else {
        return null; // Return null if the message is filtered out
    }
}

// Example implementation of BroadcastFilter as a Predicate
class BroadcastFilter implements Predicate<Object> {
    @Override
    public boolean test(Object msg) {
        // Implement your filtering logic here
        // For example, filter out messages that are null or empty strings
        return msg != null && !msg.toString().isEmpty();
    }
}