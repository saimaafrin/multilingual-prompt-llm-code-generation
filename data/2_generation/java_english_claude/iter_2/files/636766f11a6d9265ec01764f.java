import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class BeanMap {
    private Map<String, Object> map;
    
    public BeanMap() {
        this.map = new HashMap<>();
    }

    /**
     * Returns the values for the BeanMap.
     * @return values for the BeanMap. The returned collection is not modifiable.
     */
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(map.values());
    }
}