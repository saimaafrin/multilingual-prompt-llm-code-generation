import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ValueAccumulator {
    
    private Map<String, Long> accumulatorMap;
    
    public ValueAccumulator() {
        this.accumulatorMap = new ConcurrentHashMap<>();
    }
    
    /**
     * 将给定键的值与现有值累加。
     */
    public void valueAccumulation(String key, Long value) {
        if (key == null || value == null) {
            return;
        }
        
        accumulatorMap.merge(key, value, Long::sum);
    }
}