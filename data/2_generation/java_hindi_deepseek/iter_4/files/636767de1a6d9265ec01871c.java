import java.util.HashMap;
import java.util.Map;

public class Accumulator {
    private Map<String, Long> map;

    public Accumulator() {
        this.map = new HashMap<>();
    }

    /**
     * दिए गए कुंजी में मौजूदा मान के साथ मान को जोड़ें।
     * @param key कुंजी जिसके लिए मान जोड़ा जाना है
     * @param value जोड़ा जाने वाला मान
     */
    public void valueAccumulation(String key, Long value) {
        if (map.containsKey(key)) {
            Long currentValue = map.get(key);
            map.put(key, currentValue + value);
        } else {
            map.put(key, value);
        }
    }

    public Long getValue(String key) {
        return map.getOrDefault(key, 0L);
    }

    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator();
        accumulator.valueAccumulation("key1", 10L);
        accumulator.valueAccumulation("key1", 20L);
        System.out.println(accumulator.getValue("key1")); // Output: 30
    }
}