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
                // If the key is not found, binarySearch returns (-(insertion point) - 1)
                index = -index - 2;
            } else {
                // If the key is found, we want the previous element
                index--;
            }

            if (index >= 0) {
                lowerBounds.add(index);
            } else {
                // No lower bound found
                lowerBounds.add(-1);
            }
        }

        return lowerBounds;
    }
}