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
     * Devuelve los valores del BeanMap.
     * @return valores del BeanMap. La colección devuelta no es modificable.
     */
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(map.values());
    }

    // Método para agregar valores al BeanMap (opcional)
    public void put(String key, Object value) {
        map.put(key, value);
    }
}