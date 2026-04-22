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
            if (map.getWriteMethod(key) != null) {
                Object value = map.get(key);
                if (value != null) {
                    this.put(key, value);
                }
            }
        }
    }

    private void put(String key, Object value) {
        // Implementation of put method
        // This would depend on the specific BeanMap implementation
    }
}