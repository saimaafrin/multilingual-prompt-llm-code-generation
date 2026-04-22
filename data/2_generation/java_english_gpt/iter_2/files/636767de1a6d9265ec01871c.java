import java.util.HashMap;
import java.util.Map;

public class ValueAccumulator {
    private Map<String, Long> accumulatorMap;

    public ValueAccumulator() {
        this.accumulatorMap = new HashMap<>();
    }

    /** 
     * Accumulate the value with existing value in the same given key.
     */
    public void valueAccumulation(String key, Long value) {
        accumulatorMap.put(key, accumulatorMap.getOrDefault(key, 0L) + value);
    }

    public Long getValue(String key) {
        return accumulatorMap.getOrDefault(key, 0L);
    }

    public static void main(String[] args) {
        ValueAccumulator va = new ValueAccumulator();
        va.valueAccumulation("a", 10L);
        va.valueAccumulation("a", 5L);
        va.valueAccumulation("b", 20L);
        
        System.out.println("Value for key 'a': " + va.getValue("a")); // Output: 15
        System.out.println("Value for key 'b': " + va.getValue("b")); // Output: 20
    }
}