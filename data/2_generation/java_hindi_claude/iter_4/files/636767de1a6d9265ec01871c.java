import java.util.HashMap;
import java.util.Map;

public class Accumulator {
    private Map<String, Integer> accumulatorMap;

    public Accumulator() {
        accumulatorMap = new HashMap<>();
    }

    /**
     * Accumulate the value with existing value in the same given key.
     * @param key The key to accumulate value for
     * @param value The value to accumulate
     * @return The new accumulated value
     */
    public int accumulate(String key, int value) {
        int currentValue = accumulatorMap.getOrDefault(key, 0);
        int newValue = currentValue + value;
        accumulatorMap.put(key, newValue);
        return newValue;
    }
}