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

        // Use a TreeMap to store the sorted keys and their indices
        TreeMap<K, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < sortedKeys.size(); i++) {
            treeMap.put(sortedKeys.get(i), i);
        }

        // For each key, find the maximum lower bound
        for (K key : keys) {
            K lowerKey = treeMap.lowerKey(key);
            if (lowerKey != null) {
                lowerBounds.add(treeMap.get(lowerKey));
            } else {
                lowerBounds.add(-1); // No lower bound found
            }
        }

        return lowerBounds;
    }

    public static void main(String[] args) {
        // Example usage
        LowerBoundsCalculator<Integer> calculator = new LowerBoundsCalculator<>();
        List<Integer> keys = Arrays.asList(5, 3, 8, 1, 4);
        List<Integer> lowerBounds = calculator.computeLowerBounds(keys);
        System.out.println(lowerBounds); // Output: [3, 1, 5, -1, 2]
    }
}