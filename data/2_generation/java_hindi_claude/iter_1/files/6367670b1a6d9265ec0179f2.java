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
        if (key == null) {
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                if (entry.getKey() == null) {
                    return true;
                }
            }
            return false;
        }
        
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            if (key.equals(entry.getKey())) {
                return true;
            }
        }
        return false;
    }
}