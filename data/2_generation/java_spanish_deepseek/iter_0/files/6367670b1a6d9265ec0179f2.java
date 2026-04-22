import java.util.Map;

public class CustomMap<K, V> implements Map<K, V> {
    // Assuming this class has a backing data structure, e.g., a HashMap
    private Map<K, V> internalMap;

    public CustomMap() {
        this.internalMap = new java.util.HashMap<>();
    }

    @Override
    public boolean containsKey(final Object key) {
        return internalMap.containsKey(key);
    }

    // Other methods of the Map interface would need to be implemented as well
    // For example:
    @Override
    public int size() {
        return internalMap.size();
    }

    @Override
    public boolean isEmpty() {
        return internalMap.isEmpty();
    }

    @Override
    public boolean containsValue(Object value) {
        return internalMap.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return internalMap.get(key);
    }

    @Override
    public V put(K key, V value) {
        return internalMap.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return internalMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        internalMap.putAll(m);
    }

    @Override
    public void clear() {
        internalMap.clear();
    }

    @Override
    public java.util.Set<K> keySet() {
        return internalMap.keySet();
    }

    @Override
    public java.util.Collection<V> values() {
        return internalMap.values();
    }

    @Override
    public java.util.Set<Map.Entry<K, V>> entrySet() {
        return internalMap.entrySet();
    }
}