import java.util.*;

public class LowerBoundsCalculator<K extends Comparable<K>> {

    /**
     * Finds a maximum lower bound for every key.
     * @param keys list of keys.
     * @return the computed key lower bounds.
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        List<Integer> lowerBounds = new ArrayList<>();
        if (keys == null || keys.isEmpty()) {
            return lowerBounds;
        }

        // Sort the keys to facilitate finding lower bounds
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        // Use a map to store the lower bound for each key
        Map<K, Integer> lowerBoundMap = new HashMap<>();

        // Initialize the lower bound for the smallest key
        lowerBoundMap.put(sortedKeys.get(0), 0);

        // Iterate through the sorted keys to compute lower bounds
        for (int i = 1; i < sortedKeys.size(); i++) {
            K currentKey = sortedKeys.get(i);
            K previousKey = sortedKeys.get(i - 1);

            // The lower bound for the current key is the lower bound of the previous key plus 1
            lowerBoundMap.put(currentKey, lowerBoundMap.get(previousKey) + 1);
        }

        // Populate the lowerBounds list with the computed values
        for (K key : keys) {
            lowerBounds.add(lowerBoundMap.get(key));
        }

        return lowerBounds;
    }

    public static void main(String[] args) {
        // Example usage
        LowerBoundsCalculator<Integer> calculator = new LowerBoundsCalculator<>();
        List<Integer> keys = Arrays.asList(5, 3, 8, 1, 2);
        List<Integer> lowerBounds = calculator.computeLowerBounds(keys);
        System.out.println(lowerBounds); // Output: [3, 1, 4, 0, 2]
    }
}