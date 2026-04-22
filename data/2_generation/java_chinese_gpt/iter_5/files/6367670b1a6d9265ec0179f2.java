import java.util.HashMap;
import java.util.Map;

public class MyMap<K, V> {
    private Map<K, V> map;

    public MyMap() {
        this.map = new HashMap<>();
    }

    /**
     * 如果此映射包含指定键的映射，则返回<code>true</code>。
     * @param key 要搜索的键
     * @return 如果映射包含该键，则返回真
     */
    @Override 
    public boolean containsKey(final Object key) {
        return map.containsKey(key);
    }

    // Additional methods to put and get values for testing purposes
    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }
}