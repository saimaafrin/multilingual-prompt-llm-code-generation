import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LowerBoundsCalculator<K extends Comparable<K>> {

    /**
     * Finds a maximum lower bound for every key.
     * @param keys list of keys.
     * @return the computed key lower bounds.
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> lowerBounds = new ArrayList<>();
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        for (K key : keys) {
            int index = Collections.binarySearch(sortedKeys, key);
            if (index < 0) {
                // If the key is not found, the insertion point is (-index - 1)
                index = -index - 1;
            }
            // The maximum lower bound is the key at (index - 1)
            if (index > 0) {
                lowerBounds.add((Integer) sortedKeys.get(index - 1));
            } else {
                // If no lower bound exists, add null or a default value
                lowerBounds.add(null);
            }
        }

        return lowerBounds;
    }
}