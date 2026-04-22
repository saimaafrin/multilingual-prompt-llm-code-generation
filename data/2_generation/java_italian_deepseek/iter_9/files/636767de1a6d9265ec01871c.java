import java.util.HashMap;
import java.util.Map;

public class Accumulator {
    private Map<String, Long> map;

    public Accumulator() {
        this.map = new HashMap<>();
    }

    /**
     * Accumula il valore con il valore esistente nella stessa chiave fornita.
     */
    public void valueAccumulation(String key, Long value) {
        if (map.containsKey(key)) {
            Long existingValue = map.get(key);
            map.put(key, existingValue + value);
        } else {
            map.put(key, value);
        }
    }

    // Optional: Method to get the accumulated value for a key
    public Long getValue(String key) {
        return map.getOrDefault(key, 0L);
    }

    // Optional: Method to print all accumulated values
    public void printAllValues() {
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}