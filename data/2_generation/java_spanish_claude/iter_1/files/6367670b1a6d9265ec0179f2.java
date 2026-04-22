import java.util.Map;

public class CustomMap<K,V> implements Map<K,V> {

    private Entry<K,V>[] entries;
    private int size;

    @Override 
    public boolean containsKey(final Object key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (entries[i] != null && entries[i].getKey() == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (entries[i] != null && key.equals(entries[i].getKey())) {
                    return true;
                }
            }
        }
        return false;
    }

    // Other Map interface methods would be implemented here
}