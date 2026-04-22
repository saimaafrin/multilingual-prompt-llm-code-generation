import java.util.Map;
import java.util.HashMap;

public class MapContains {
    private Map<Object, Object> map = new HashMap<>();
    
    /**
     * Return <code>true</code> if this map contains a mapping for the specified key.
     * @param key the key to be searched for
     * @return true if the map contains the key
     */
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }
}