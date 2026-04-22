import java.util.function.Predicate;

/**
 * Invoke the {@link BroadcastFilter}
 * @param msg the message to be filtered
 * @return the filtered message or null if the message is filtered out
 */
protected Object filter(Object msg) {
    // Assuming BroadcastFilter is a functional interface or a class with a test method
    // For example, it could be a Predicate<Object>
    Predicate<Object> broadcastFilter = /* initialize your BroadcastFilter here */;

    if (broadcastFilter != null && broadcastFilter.test(msg)) {
        return msg; // Message passes the filter
    } else {
        return null; // Message is filtered out
    }
}