import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BeanMap {
    private Map<String, Object> map;

    public BeanMap() {
        this.map = new HashMap<>();
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    /**
     * Restituisce i valori per il BeanMap.
     * @return valori per il BeanMap. La collezione restituita non è modificabile.
     */
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(map.values());
    }

    public static void main(String[] args) {
        BeanMap beanMap = new BeanMap();
        beanMap.put("key1", "value1");
        beanMap.put("key2", "value2");

        Collection<Object> values = beanMap.values();
        System.out.println(values); // Output: [value1, value2]
    }
}