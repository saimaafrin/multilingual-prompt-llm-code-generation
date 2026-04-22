import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BeanMap {
    private Map<String, Object> map;

    public BeanMap() {
        this.map = new HashMap<>();
    }

    /**
     * BeanMap के लिए मान लौटाता है।
     * @return BeanMap के लिए मान। लौटाई गई संग्रह को संशोधित नहीं किया जा सकता है।
     */
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(map.values());
    }

    // Method to add values to the map for testing purposes
    public void put(String key, Object value) {
        map.put(key, value);
    }

    // Main method for testing
    public static void main(String[] args) {
        BeanMap beanMap = new BeanMap();
        beanMap.put("key1", "value1");
        beanMap.put("key2", 42);
        
        Collection<Object> values = beanMap.values();
        System.out.println(values); // Output: [value1, 42]
        
        // Uncommenting the next line will throw an UnsupportedOperationException
        // values.add("newValue");
    }
}