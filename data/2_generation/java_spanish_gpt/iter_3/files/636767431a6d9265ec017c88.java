import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LowerBoundsCalculator<K> {

    /** 
     * Encuentra un límite inferior máximo para cada llave.
     * @param keys lista de llaves.
     * @return los límites inferiores de llaves calculados.
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        Map<K, Integer> lowerBoundsMap = new HashMap<>();
        List<Integer> lowerBounds = new ArrayList<>();

        for (K key : keys) {
            // Simulate the computation of a lower bound for each key
            int lowerBound = computeLowerBoundForKey(key);
            lowerBoundsMap.put(key, lowerBound);
        }

        for (K key : keys) {
            lowerBounds.add(lowerBoundsMap.get(key));
        }

        return lowerBounds;
    }

    private int computeLowerBoundForKey(K key) {
        // Placeholder for actual lower bound computation logic
        // For demonstration, we return a random value
        return key.hashCode() % 100; // Example computation
    }

    public static void main(String[] args) {
        LowerBoundsCalculator<String> calculator = new LowerBoundsCalculator<>();
        List<String> keys = List.of("key1", "key2", "key3");
        List<Integer> lowerBounds = calculator.computeLowerBounds(keys);
        System.out.println(lowerBounds);
    }
}