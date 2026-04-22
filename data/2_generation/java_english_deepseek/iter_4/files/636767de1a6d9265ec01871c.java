import java.util.HashMap;
import java.util.Map;

public class Accumulator {
    private Map<String, Long> map;

    public Accumulator() {
        this.map = new HashMap<>();
    }

    /**
     * Accumulate the value with existing value in the same given key.
     * If the key does not exist, it will be initialized with the given value.
     *
     * @param key   The key to accumulate the value for.
     * @param value The value to accumulate.
     */
    public void valueAccumulation(String key, Long value) {
        map.put(key, map.getOrDefault(key, 0L) + value);
    }

    // Optional: Method to get the accumulated value for a key
    public Long getAccumulatedValue(String key) {
        return map.getOrDefault(key, 0L);
    }

    // Optional: Method to clear the accumulator
    public void clear() {
        map.clear();
    }
}