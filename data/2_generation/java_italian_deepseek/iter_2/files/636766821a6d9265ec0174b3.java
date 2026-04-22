import java.util.function.Function;

/**
 * Invoca il {@link BroadcastFilter}
 * @param msg Il messaggio da filtrare
 * @return Il messaggio filtrato
 */
protected Object filter(Object msg) {
    // Assuming BroadcastFilter is a functional interface or a class with a filter method
    // For example, let's assume BroadcastFilter is a Function<Object, Object>
    BroadcastFilter filter = new BroadcastFilter();
    return filter.apply(msg);
}

// Assuming BroadcastFilter is a functional interface or a class with a filter method
class BroadcastFilter implements Function<Object, Object> {
    @Override
    public Object apply(Object msg) {
        // Implement the filtering logic here
        // For example, just return the message as is (no filtering)
        return msg;
    }
}