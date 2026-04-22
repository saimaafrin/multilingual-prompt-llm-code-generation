import org.apache.commons.beanutils.BeanMap;

public class BeanMapUtils {

    /**
     * 将给定 BeanMap 中所有可写属性放入此 BeanMap。只读和只写属性将被忽略。
     * @param map  要放入的 BeanMap
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("The input BeanMap cannot be null.");
        }

        // 获取目标 BeanMap 的所有可写属性
        for (Object key : map.keySet()) {
            if (map.isWriteable(key.toString())) {
                // 获取源 BeanMap 中的属性值
                Object value = map.get(key);
                // 将属性值放入目标 BeanMap
                this.put(key, value);
            }
        }
    }
}