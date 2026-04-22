import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BeanMap {
    private Map<String, Object> map;

    public BeanMap() {
        this.map = new HashMap<>();
    }

    /**
     * Restituisce i valori per il BeanMap.
     * @return valori per il BeanMap. La collezione restituita non è modificabile.
     */
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(map.values());
    }

    // Example method to add values to the map
    public void put(String key, Object value) {
        map.put(key, value);
    }

    // Example method to get a value from the map
    public Object get(String key) {
        return map.get(key);
    }

    // Example method to remove a value from the map
    public Object remove(String key) {
        return map.remove(key);
    }
}