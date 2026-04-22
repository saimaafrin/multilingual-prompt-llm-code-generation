import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class BeanMap {
    private Map<Object, Object> map;

    public BeanMap(Map<Object, Object> map) {
        this.map = map;
    }

    /**
     * BeanMap के लिए मान लौटाता है।
     * @return BeanMap के लिए मान। लौटाई गई संग्रह को संशोधित नहीं किया जा सकता है।
     */
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(map.values());
    }
}