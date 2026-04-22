import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LowerBoundCalculator<K extends Comparable<K>> {

    /** 
     * Finds a maximum lower bound for every key.
     * @param keys list of keys.
     * @return the computed key lower bounds.
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        Map<K, Integer> lowerBounds = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (K key : keys) {
            // Compute the lower bound for the key
            int lowerBound = computeLowerBoundForKey(key, keys);
            lowerBounds.put(key, lowerBound);
            result.add(lowerBound);
        }

        return result;
    }

    private int computeLowerBoundForKey(K key, List<K> keys) {
        int lowerBound = Integer.MIN_VALUE;
        for (K k : keys) {
            if (k.compareTo(key) < 0) {
                lowerBound = Math.max(lowerBound, (Integer) k);
            }
        }
        return lowerBound == Integer.MIN_VALUE ? null : lowerBound;
    }
}