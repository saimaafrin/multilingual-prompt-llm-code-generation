import java.util.ArrayList;
import java.util.List;

public class UpperBoundCalculator<K extends Comparable<K>> {

    /** 
     * Finds a minimum lower bound for every key.
     * @param keys a list of keys.
     * @return the computed key upper bound.
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        List<Integer> upperBounds = new ArrayList<>();
        for (K key : keys) {
            // Assuming the upper bound is the ordinal value of the key
            // This is a placeholder logic; actual logic may vary based on requirements
            upperBounds.add(key.hashCode()); // Using hashCode as a simple upper bound
        }
        return upperBounds;
    }
    
    public static void main(String[] args) {
        UpperBoundCalculator<String> calculator = new UpperBoundCalculator<>();
        List<String> keys = List.of("apple", "banana", "cherry");
        List<Integer> upperBounds = calculator.computeUpperBounds(keys);
        System.out.println(upperBounds);
    }
}