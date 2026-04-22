import java.util.Objects;

/**
 * Invoke the {@link BroadcastFilter}
 * @param msg The message to be filtered
 * @return The filtered message or null if the message is filtered out
 */
protected Object filter(Object msg) {
    // Assuming BroadcastFilter is an interface or class that defines a filtering mechanism
    // For the sake of this example, let's assume BroadcastFilter has a method called filterMessage
    // which takes an Object and returns a filtered Object or null if the message is filtered out.

    // Example implementation:
    if (msg == null) {
        return null;
    }

    // Example filtering logic: filter out messages that are empty strings
    if (msg instanceof String && ((String) msg).trim().isEmpty()) {
        return null;
    }

    // Example filtering logic: filter out messages that are not instances of a specific class
    if (!(msg instanceof MyCustomMessageClass)) {
        return null;
    }

    // If the message passes all filters, return it as is
    return msg;
}

// Example custom message class
class MyCustomMessageClass {
    private String content;

    public MyCustomMessageClass(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCustomMessageClass that = (MyCustomMessageClass) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}