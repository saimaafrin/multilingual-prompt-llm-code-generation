import java.util.HashMap;
import java.util.Map;

public class Accumulator {
    private Map<String, Long> map;

    public Accumulator() {
        this.map = new HashMap<>();
    }

    /**
     * Accumulate the value with existing value in the same given key.
     */
    public void valueAccumulation(String key, Long value) {
        map.put(key, map.getOrDefault(key, 0L) + value);
    }

    // Optional: Method to get the accumulated value for a key
    public Long getAccumulatedValue(String key) {
        return map.getOrDefault(key, 0L);
    }

    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator();
        accumulator.valueAccumulation("key1", 10L);
        accumulator.valueAccumulation("key1", 20L);
        System.out.println(accumulator.getAccumulatedValue("key1")); // Output: 30
    }
}