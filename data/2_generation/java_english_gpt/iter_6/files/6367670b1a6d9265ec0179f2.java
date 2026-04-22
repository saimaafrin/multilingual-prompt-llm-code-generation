import java.util.HashMap;
import java.util.Map;

public class MyMap<K, V> {
    private Map<K, V> map;

    public MyMap() {
        this.map = new HashMap<>();
    }

    @Override
    public boolean containsKey(final Object key) {
        return map.containsKey(key);
    }

    // Additional methods to add and retrieve values can be added here
}