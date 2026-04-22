import java.util.Map;

public class MyMap<K, V> implements Map<K, V> {
    // Assume this class has a backing data structure, e.g., a HashMap
    private final Map<K, V> internalMap;

    public MyMap() {
        this.internalMap = new java.util.HashMap<>();
    }

    @Override
    public boolean containsKey(final Object key) {
        return internalMap.containsKey(key);
    }

    // Other methods of the Map interface would need to be implemented here
}