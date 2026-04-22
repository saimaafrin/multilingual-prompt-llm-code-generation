import java.util.ArrayList;
import java.util.List;

public class LowerBoundCalculator<K extends Comparable<K>> {

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

        for (K key : keys) {
            int lowerBound = findLowerBound(key, keys);
            lowerBounds.add(lowerBound);
        }
        return lowerBounds;
    }

    private int findLowerBound(K key, List<K> keys) {
        int lowerBound = Integer.MIN_VALUE;
        for (K k : keys) {
            if (k.compareTo(key) < 0) {
                lowerBound = Math.max(lowerBound, (Integer) k);
            }
        }
        return lowerBound;
    }
}