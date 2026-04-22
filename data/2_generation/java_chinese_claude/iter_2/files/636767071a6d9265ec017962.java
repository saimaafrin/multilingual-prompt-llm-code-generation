import org.apache.commons.beanutils.BeanMap;
import java.util.Iterator;

public class BeanMapUtils {
    
    /**
     * 将给定 BeanMap 中所有可写属性放入此 BeanMap。只读和只写属性将被忽略。
     * @param map 要放入的 BeanMap
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            return;
        }

        Iterator<?> it = map.keyIterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            if (map.isWriteable(key)) {
                Object value = map.get(key);
                if (this.isWriteable(key)) {
                    this.put(key, value);
                }
            }
        }
    }

    /**
     * Helper method to check if a property is writeable
     */
    private boolean isWriteable(String propertyName) {
        return ((BeanMap)this).isWriteable(propertyName);
    }

    /**
     * Helper method to put a key-value pair
     */
    private void put(String key, Object value) {
        ((BeanMap)this).put(key, value);
    }
}