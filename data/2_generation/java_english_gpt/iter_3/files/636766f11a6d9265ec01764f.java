import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BeanMap {
    private final Map<String, Object> map;

    public BeanMap() {
        this.map = new HashMap<>();
    }

    /**
     * Returns the values for the BeanMap.
     * @return values for the BeanMap. The returned collection is not modifiable.
     */
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(map.values());
    }

    // Method to put values into the map for testing purposes
    public void put(String key, Object value) {
        map.put(key, value);
    }
}