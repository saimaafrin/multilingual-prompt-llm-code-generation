import java.util.Map;

public class CustomMap<K, V> implements Map<K, V> {
    // Assuming this class has a backing data structure, e.g., a HashMap
    private final Map<K, V> internalMap;

    public CustomMap() {
        this.internalMap = new java.util.HashMap<>();
    }

    /**
     * Devuelve <code>true</code> si este map contiene un mapeo para la llave especificada.
     * @param key  la llave que se va a buscar
     * @return true si el mapa contiene la llave
     */
    @Override
    public boolean containsKey(final Object key) {
        return internalMap.containsKey(key);
    }

    // Other methods of the Map interface would need to be implemented as well
}