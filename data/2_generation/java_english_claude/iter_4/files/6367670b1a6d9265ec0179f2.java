import java.util.Map;

public class CustomMap<K,V> implements Map<K,V> {

    private Entry<K,V>[] table;
    private static final int DEFAULT_CAPACITY = 16;
    
    @SuppressWarnings("unchecked")
    public CustomMap() {
        table = new Entry[DEFAULT_CAPACITY];
    }

    /** 
     * Return <code>true</code> if this map contains a mapping for the specified key.
     * @param key  the key to be searched for
     * @return true if the map contains the key
     */
    @Override
    public boolean containsKey(final Object key) {
        if (key == null) {
            return false;
        }
        
        int hash = key.hashCode();
        int index = Math.abs(hash % table.length);
        
        Entry<K,V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    private static class Entry<K,V> {
        K key;
        V value; 
        Entry<K,V> next;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}