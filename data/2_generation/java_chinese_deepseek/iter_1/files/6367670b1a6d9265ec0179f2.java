import java.util.Map;

public class MyMap<K, V> implements Map<K, V> {
    private final Map<K, V> internalMap;

    public MyMap(Map<K, V> internalMap) {
        this.internalMap = internalMap;
    }

    /**
     * 如果此映射包含指定键的映射，则返回<code>true</code>。
     * @param key 要搜索的键
     * @return 如果映射包含该键，则返回真
     */
    @Override
    public boolean containsKey(final Object key) {
        return internalMap.containsKey(key);
    }

    // Other methods of the Map interface would need to be implemented here
}