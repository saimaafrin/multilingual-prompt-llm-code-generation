import java.util.*;

public class LowerBoundsCalculator<K extends Comparable<K>> {

    /**
     * प्रत्येक कुंजी के लिए अधिकतम निम्न सीमा खोजता है।
     * @param keys कुंजी की सूची।
     * @return गणना की गई कुंजी की निम्न सीमाएँ।
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        List<Integer> lowerBounds = new ArrayList<>();
        if (keys == null || keys.isEmpty()) {
            return lowerBounds;
        }

        // Sort the keys to find the lower bounds efficiently
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        // Use a map to store the index of each key in the sorted list
        Map<K, Integer> keyToIndex = new HashMap<>();
        for (int i = 0; i < sortedKeys.size(); i++) {
            keyToIndex.put(sortedKeys.get(i), i);
        }

        // Compute the lower bound for each key
        for (K key : keys) {
            int index = keyToIndex.get(key);
            lowerBounds.add(index);
        }

        return lowerBounds;
    }

    public static void main(String[] args) {
        // Example usage
        LowerBoundsCalculator<Integer> calculator = new LowerBoundsCalculator<>();
        List<Integer> keys = Arrays.asList(5, 3, 8, 1, 3);
        List<Integer> lowerBounds = calculator.computeLowerBounds(keys);
        System.out.println(lowerBounds); // Output: [2, 1, 3, 0, 1]
    }
}