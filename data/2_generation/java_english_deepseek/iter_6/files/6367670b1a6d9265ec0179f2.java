import java.util.Map;

public class CustomMap<K, V> implements Map<K, V> {
    // Assuming this class has a private field `map` that holds the actual map data
    private final Map<K, V> map;

    public CustomMap(Map<K, V> map) {
        this.map = map;
    }

    /**
     * Return <code>true</code> if this map contains a mapping for the specified key.
     * @param key  the key to be searched for
     * @return true if the map contains the key
     */
    @Override
    public boolean containsKey(final Object key) {
        return map.containsKey(key);
    }

    // Other methods of the Map interface would need to be implemented here
}