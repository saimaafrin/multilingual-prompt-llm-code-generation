import java.util.HashMap;
import java.util.Map;

public class MyMap<K, V> {
    private Map<K, V> map;

    public MyMap() {
        this.map = new HashMap<>();
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

    // Método para agregar elementos al mapa
    public void put(K key, V value) {
        map.put(key, value);
    }

    // Método para obtener elementos del mapa
    public V get(K key) {
        return map.get(key);
    }
}