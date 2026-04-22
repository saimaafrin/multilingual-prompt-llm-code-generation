import java.util.Objects;

/**
 * Invoke the {@link BroadcastFilter}
 * @param msg The message to be filtered
 * @return The filtered message or null if the message is filtered out
 */
protected Object filter(Object msg) {
    // Assuming BroadcastFilter is an interface or class that defines a filter method
    // For the sake of this example, let's assume it has a method called filterMessage
    BroadcastFilter filter = new BroadcastFilter() {
        @Override
        public Object filterMessage(Object message) {
            // Example filtering logic: filter out null messages
            if (message == null) {
                return null;
            }
            // Example: filter out messages that are not instances of String
            if (!(message instanceof String)) {
                return null;
            }
            // Example: filter out empty strings
            if (((String) message).trim().isEmpty()) {
                return null;
            }
            // Otherwise, return the message as is
            return message;
        }
    };

    // Invoke the filter
    return filter.filterMessage(msg);
}

// Assuming BroadcastFilter is an interface
interface BroadcastFilter {
    Object filterMessage(Object message);
}