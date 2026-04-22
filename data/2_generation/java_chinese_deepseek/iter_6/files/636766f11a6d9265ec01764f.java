import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class BeanMap {
    private Map<String, Object> map;

    public BeanMap(Map<String, Object> map) {
        this.map = map;
    }

    /**
     * 返回 BeanMap 的值。
     * @return BeanMap 的值。返回的集合是不可修改的。
     */
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(map.values());
    }
}