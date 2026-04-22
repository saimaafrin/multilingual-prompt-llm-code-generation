import java.util.*;

public class LowerBoundsCalculator<K extends Comparable<K>> {

    /**
     * Finds a maximum lower bound for every key.
     * @param keys list of keys.
     * @return the computed key lower bounds.
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return new ArrayList<>();
        }

        // Sort the keys to facilitate finding lower bounds
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        // Map to store the lower bounds for each key
        Map<K, Integer> lowerBounds = new HashMap<>();

        // Initialize the lower bound for the smallest key
        lowerBounds.put(sortedKeys.get(0), -1);

        // Iterate through the sorted keys to compute lower bounds
        for (int i = 1; i < sortedKeys.size(); i++) {
            K currentKey = sortedKeys.get(i);
            K previousKey = sortedKeys.get(i - 1);

            // The lower bound for the current key is the previous key
            lowerBounds.put(currentKey, (Integer) previousKey);
        }

        // Prepare the result list in the order of the original keys
        List<Integer> result = new ArrayList<>();
        for (K key : keys) {
            result.add(lowerBounds.get(key));
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        LowerBoundsCalculator<Integer> calculator = new LowerBoundsCalculator<>();
        List<Integer> keys = Arrays.asList(5, 3, 8, 1, 2);
        List<Integer> lowerBounds = calculator.computeLowerBounds(keys);
        System.out.println(lowerBounds); // Output: [3, 1, 5, -1, 1]
    }
}