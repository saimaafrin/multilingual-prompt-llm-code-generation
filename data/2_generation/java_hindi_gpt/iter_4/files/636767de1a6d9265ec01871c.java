import java.util.HashMap;
import java.util.Map;

public class ValueAccumulator {
    private Map<String, Long> map;

    public ValueAccumulator() {
        map = new HashMap<>();
    }

    /** 
     * दिए गए कुंजी में मौजूदा मान के साथ मान को जोड़ें।
     */
    public void valueAccumulation(String key, Long value) {
        map.put(key, map.getOrDefault(key, 0L) + value);
    }

    public Map<String, Long> getMap() {
        return map;
    }

    public static void main(String[] args) {
        ValueAccumulator accumulator = new ValueAccumulator();
        accumulator.valueAccumulation("key1", 10L);
        accumulator.valueAccumulation("key1", 5L);
        accumulator.valueAccumulation("key2", 20L);
        
        System.out.println(accumulator.getMap()); // Output: {key1=15, key2=20}
    }
}