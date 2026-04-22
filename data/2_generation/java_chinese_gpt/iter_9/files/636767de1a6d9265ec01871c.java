import java.util.HashMap;
import java.util.Map;

public class ValueAccumulator {
    private Map<String, Long> map;

    public ValueAccumulator() {
        this.map = new HashMap<>();
    }

    /** 
     * 将给定键的值与现有值累加。
     */
    public void valueAccumulation(String key, Long value) {
        map.put(key, map.getOrDefault(key, 0L) + value);
    }

    public Long getValue(String key) {
        return map.getOrDefault(key, 0L);
    }

    public static void main(String[] args) {
        ValueAccumulator accumulator = new ValueAccumulator();
        accumulator.valueAccumulation("a", 10L);
        accumulator.valueAccumulation("a", 5L);
        System.out.println(accumulator.getValue("a")); // Output: 15
    }
}