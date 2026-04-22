import java.util.Map;

public class CustomMap<K, V> implements Map<K, V> {
    // Assuming this class has a backing data structure, e.g., a HashMap
    private final Map<K, V> internalMap;

    public CustomMap(Map<K, V> internalMap) {
        this.internalMap = internalMap;
    }

    /**
     * Return <code>true</code> if this map contains a mapping for the specified key.
     * @param key  the key to be searched for
     * @return true if the map contains the key
     */
    @Override
    public boolean containsKey(final Object key) {
        return internalMap.containsKey(key);
    }

    // Other methods of the Map interface would need to be implemented here
}