import java.util.Map;

public class MyMap<K, V> implements Map<K, V> {
    // Assume this class has a backing data structure, e.g., a HashMap
    private final Map<K, V> internalMap;

    public MyMap(Map<K, V> internalMap) {
        this.internalMap = internalMap;
    }

    /** 
     * Restituisce <code>true</code> se questa mappa contiene una mappatura per la chiave specificata.
     * @param key  la chiave da cercare
     * @return true se la mappa contiene la chiave
     */
    @Override
    public boolean containsKey(final Object key) {
        return internalMap.containsKey(key);
    }

    // Other methods of the Map interface would need to be implemented here
}