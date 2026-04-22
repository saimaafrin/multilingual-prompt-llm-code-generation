import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class BeanMap {

    private Map<String, Object> map;

    public BeanMap(Map<String, Object> map) {
        this.map = map;
    }

    /**
     * Restituisce i valori per il BeanMap.
     * @return valori per il BeanMap. La collezione restituita non è modificabile.
     */
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(map.values());
    }
}