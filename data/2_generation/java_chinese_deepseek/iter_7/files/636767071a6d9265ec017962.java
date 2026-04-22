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
            if (this.isWriteable(key)) {
                this.put(key, map.get(key));
            }
        }
    }

    /**
     * 检查给定的属性是否可写
     * @param key 属性名
     * @return 如果属性可写则返回 true，否则返回 false
     */
    private boolean isWriteable(Object key) {
        try {
            this.getType(key); // 如果属性不存在会抛出异常
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // 以下方法为 BeanMap 的默认方法，假设它们已经存在
    public Object get(Object key) {
        // 实现获取属性值的逻辑
        return null;
    }

    public void put(Object key, Object value) {
        // 实现设置属性值的逻辑
    }

    public Class<?> getType(Object key) {
        // 实现获取属性类型的逻辑
        return null;
    }

    public Iterable<Object> keySet() {
        // 实现获取所有键的逻辑
        return null;
    }
}