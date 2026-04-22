import org.apache.commons.beanutils.BeanMap;
import java.util.Iterator;

public class BeanMapUtils {
    
    /**
     * Puts all of the writable properties from the given BeanMap into this BeanMap. 
     * Read-only and Write-only properties will be ignored.
     * @param map the BeanMap whose properties to put
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            return;
        }

        Iterator<?> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            BeanMap.Entry entry = (BeanMap.Entry) entries.next();
            String propertyName = (String) entry.getKey();
            
            // Check if property is writable in source map
            if (map.isWriteable(propertyName)) {
                Object value = entry.getValue();
                // Only set if property exists and is writable in target
                if (this.containsKey(propertyName) && this.isWriteable(propertyName)) {
                    this.put(propertyName, value);
                }
            }
        }
    }
}