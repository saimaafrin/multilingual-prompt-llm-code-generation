import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BeanMap {
    private final Map<String, Object> map;

    public BeanMap() {
        this.map = new HashMap<>();
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    /**
     * 返回 BeanMap 的值。
     * @return BeanMap 的值。返回的集合是不可修改的。
     */
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(map.values());
    }

    public static void main(String[] args) {
        BeanMap beanMap = new BeanMap();
        beanMap.put("key1", "value1");
        beanMap.put("key2", 2);
        
        Collection<Object> values = beanMap.values();
        System.out.println(values);
    }
}