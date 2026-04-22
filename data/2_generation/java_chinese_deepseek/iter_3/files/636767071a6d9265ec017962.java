import org.apache.commons.beanutils.BeanMap;

public class BeanMapUtils {

    /**
     * 将给定 BeanMap 中所有可写属性放入此 BeanMap。只读和只写属性将被忽略。
     * @param map  要放入的 BeanMap
     */
    public void putAllWriteable(BeanMap target, BeanMap source) {
        if (source == null || target == null) {
            return;
        }

        for (Object key : source.keySet()) {
            if (target.getWriteMethod(key) != null && source.getReadMethod(key) != null) {
                target.put(key, source.get(key));
            }
        }
    }
}