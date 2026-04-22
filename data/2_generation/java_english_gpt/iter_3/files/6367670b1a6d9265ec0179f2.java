import java.util.HashMap;
import java.util.Map;

public class MyMap<K, V> {
    private Map<K, V> map;

    public MyMap() {
        this.map = new HashMap<>();
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

    // Additional methods to add and remove entries for testing purposes
    public void put(K key, V value) {
        map.put(key, value);
    }

    public void remove(K key) {
        map.remove(key);
    }
}