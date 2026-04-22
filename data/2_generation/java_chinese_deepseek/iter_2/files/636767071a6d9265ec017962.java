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
                Object value = map.get(key);
                this.put(key, value);
            }
        }
    }

    // 假设 BeanMap 类有一个 put 方法
    public void put(Object key, Object value) {
        // 这里假设 BeanMap 有一个 put 方法
        // 实际实现可能需要根据具体需求进行调整
        // 例如: this.map.put(key, value);
    }
}