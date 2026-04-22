import org.apache.commons.beanutils.BeanMap;
import java.util.Iterator;

public class BeanMapUtils {

    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            return;
        }

        Iterator<?> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            BeanMap.Entry entry = (BeanMap.Entry) entries.next();
            String propertyName = (String) entry.getKey();
            
            // Check if property is writable
            if (map.getWriteMethod(propertyName) != null) {
                Object value = entry.getValue();
                try {
                    // Only put if property exists and is writable
                    if (this.containsKey(propertyName) && 
                        this.getWriteMethod(propertyName) != null) {
                        this.put(propertyName, value);
                    }
                } catch (Exception e) {
                    // Skip property if there's an error setting it
                    continue;
                }
            }
        }
    }
}