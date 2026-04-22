import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UpperBoundCalculator<K extends Comparable<K>> {

    /** 
     * Finds a minimum lower bound for every key.
     * @param keys a list of keys.
     * @return the computed key upper bound.
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        List<Integer> upperBounds = new ArrayList<>();
        
        if (keys == null || keys.isEmpty()) {
            return upperBounds; // Return empty list if input is null or empty
        }

        // Sort the keys to find upper bounds
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        for (K key : sortedKeys) {
            int upperBound = Collections.binarySearch(sortedKeys, key);
            if (upperBound < 0) {
                upperBound = -(upperBound + 1); // Convert to insertion point
            }
            upperBounds.add(upperBound);
        }

        return upperBounds;
    }
}