import java.util.HashMap;
import java.util.Map;

public class ValueAccumulator {
    private Map<String, Long> storage;

    public ValueAccumulator() {
        storage = new HashMap<>();
    }

    /** 
     * 将给定键的值与现有值累加。
     */
    public void valueAccumulation(String key, Long value) {
        storage.put(key, storage.getOrDefault(key, 0L) + value);
    }

    public Long getValue(String key) {
        return storage.getOrDefault(key, 0L);
    }

    public static void main(String[] args) {
        ValueAccumulator accumulator = new ValueAccumulator();
        accumulator.valueAccumulation("testKey", 10L);
        accumulator.valueAccumulation("testKey", 5L);
        System.out.println(accumulator.getValue("testKey")); // Output: 15
    }
}