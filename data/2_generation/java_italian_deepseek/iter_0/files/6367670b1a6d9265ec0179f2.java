import java.util.Map;

public class MyMap<K, V> implements Map<K, V> {
    // Assuming this class has a private field `entries` that stores the key-value pairs
    private final Map<K, V> entries;

    public MyMap(Map<K, V> entries) {
        this.entries = entries;
    }

    @Override
    public boolean containsKey(final Object key) {
        return entries.containsKey(key);
    }

    // Other methods of the Map interface would need to be implemented here
}