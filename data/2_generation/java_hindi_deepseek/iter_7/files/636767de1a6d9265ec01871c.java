import java.util.HashMap;
import java.util.Map;

public class Accumulator {
    private Map<String, Long> map;

    public Accumulator() {
        this.map = new HashMap<>();
    }

    /**
     * दिए गए कुंजी में मौजूदा मान के साथ मान को जोड़ें।
     */
    public void valueAccumulation(String key, Long value) {
        if (map.containsKey(key)) {
            Long currentValue = map.get(key);
            map.put(key, currentValue + value);
        } else {
            map.put(key, value);
        }
    }

    // Optional: Method to get the accumulated value for a key
    public Long getAccumulatedValue(String key) {
        return map.getOrDefault(key, 0L);
    }

    // Optional: Method to clear the accumulated values
    public void clear() {
        map.clear();
    }
}