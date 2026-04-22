import java.util.Map;

public class CustomMap<K,V> implements Map<K,V> {

    private Entry<K,V>[] table;
    
    /**
     * 如果此映射包含指定键的映射，则返回<code>true</code>。
     * @param key 要搜索的键
     * @return 如果映射包含该键，则返回真
     */
    @Override
    public boolean containsKey(final Object key) {
        if (key == null) {
            for (Entry<K,V> entry : table) {
                if (entry != null && entry.getKey() == null) {
                    return true;
                }
            }
        } else {
            for (Entry<K,V> entry : table) {
                if (entry != null && key.equals(entry.getKey())) {
                    return true;
                }
            }
        }
        return false;
    }
}