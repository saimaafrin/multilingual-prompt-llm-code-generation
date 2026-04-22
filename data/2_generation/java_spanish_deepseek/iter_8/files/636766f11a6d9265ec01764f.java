import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class BeanMap {
    private Map<String, Object> map;

    public BeanMap(Map<String, Object> map) {
        this.map = map;
    }

    /**
     * Devuelve los valores del BeanMap.
     * @return valores del BeanMap. La colección devuelta no es modificable.
     */
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(map.values());
    }
}