import java.util.Map;

public class CustomMap<K,V> implements Map<K,V> {

    private Entry<K,V>[] table;
    
    @Override 
    public boolean containsKey(final Object key) {
        if (key == null) {
            return false;
        }
        
        if (table == null || table.length == 0) {
            return false;
        }

        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % table.length;
        
        for (Entry<K,V> entry = table[index]; entry != null; entry = entry.next) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        
        return false;
    }
    
    // Inner class for map entries
    private static class Entry<K,V> implements Map.Entry<K,V> {
        K key;
        V value; 
        Entry<K,V> next;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() { return key; }
        public V getValue() { return value; }
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }
}