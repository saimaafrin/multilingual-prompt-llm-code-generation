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

        // 获取当前 BeanMap 的所有可写属性
        for (Object key : map.keySet()) {
            if (this.isWriteable(key.toString())) {
                this.put(key, map.get(key));
            }
        }
    }

    // 假设 BeanMap 类中有 isWriteable 和 put 方法
    private boolean isWriteable(String propertyName) {
        // 这里假设 BeanMap 有一个方法可以检查属性是否可写
        // 实际实现可能需要根据 BeanMap 的具体实现进行调整
        return true; // 示例实现，实际应根据属性是否可写返回 true 或 false
    }

    private void put(Object key, Object value) {
        // 这里假设 BeanMap 有一个 put 方法用于设置属性值
        // 实际实现可能需要根据 BeanMap 的具体实现进行调整
    }
}