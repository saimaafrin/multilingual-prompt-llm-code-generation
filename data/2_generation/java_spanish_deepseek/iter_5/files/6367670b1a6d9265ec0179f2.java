import java.util.Map;

public class CustomMap<K, V> implements Map<K, V> {
    // Assuming this class has a private field 'map' that holds the actual map data
    private final Map<K, V> map;

    public CustomMap(Map<K, V> map) {
        this.map = map;
    }

    /**
     * Devuelve <code>true</code> si este map contiene un mapeo para la llave especificada.
     * @param key  la llave que se va a buscar
     * @return true si el mapa contiene la llave
     */
    @Override
    public boolean containsKey(final Object key) {
        return map.containsKey(key);
    }

    // Other methods of the Map interface would need to be implemented here
}