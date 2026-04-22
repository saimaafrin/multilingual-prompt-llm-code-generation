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

    public Collection<Object> values() {
        if (map == null || map.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableCollection(map.values());
    }
}