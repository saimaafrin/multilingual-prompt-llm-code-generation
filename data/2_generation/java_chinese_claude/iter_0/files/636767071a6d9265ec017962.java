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

        Iterator<?> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            BeanMap.Entry entry = (BeanMap.Entry) entries.next();
            String propertyName = entry.getKey().toString();
            
            // 检查属性是否可写
            if (map.getWriteMethod(propertyName) != null) {
                Object value = entry.getValue();
                try {
                    // 只复制可写属性
                    this.put(propertyName, value);
                } catch (Exception e) {
                    // 忽略无法写入的属性
                    continue;
                }
            }
        }
    }
}