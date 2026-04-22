import org.apache.commons.beanutils.BeanMap;
import java.util.Iterator;

public class BeanMapUtils {
    
    /**
     * Puts all of the writable properties from the given BeanMap into this BeanMap. Read-only and Write-only properties will be ignored.
     * @param map the BeanMap whose properties to put
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            return;
        }

        Iterator<String> it = map.keyIterator();
        while (it.hasNext()) {
            String propertyName = it.next();
            
            // Check if property is writable
            if (map.isWriteable(propertyName)) {
                Object value = map.get(propertyName);
                try {
                    // Only put if property exists and is writable in this map
                    if (this.containsKey(propertyName) && this.isWriteable(propertyName)) {
                        this.put(propertyName, value);
                    }
                } catch (IllegalArgumentException e) {
                    // Skip properties that can't be written
                    continue;
                }
            }
        }
    }
}