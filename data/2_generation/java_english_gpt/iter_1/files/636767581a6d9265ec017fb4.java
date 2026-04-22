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
            int upperBound = findUpperBound(sortedKeys, key);
            upperBounds.add(upperBound);
        }

        return upperBounds;
    }

    private int findUpperBound(List<K> sortedKeys, K key) {
        int left = 0;
        int right = sortedKeys.size();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sortedKeys.get(mid).compareTo(key) <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left; // The index of the first element greater than key
    }
}