import java.util.Map;
import java.util.HashMap;

public class Accumulator {
    private Map<String, Long> accumulatorMap;
    
    public Accumulator() {
        accumulatorMap = new HashMap<>();
    }

    /**
     * Accumulate the value with existing value in the same given key.
     */
    public void valueAccumulation(String key, Long value) {
        if (key == null || value == null) {
            return;
        }
        
        accumulatorMap.merge(key, value, Long::sum);
    }
}