import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class UpperBoundCalculator<K extends Comparable<K>> {

    /**
     * Finds a minimum lower bound for every key.
     * @param keys a list of keys.
     * @return the computed key upper bound.
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> upperBounds = new ArrayList<>();
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        for (K key : keys) {
            int index = Collections.binarySearch(sortedKeys, key);
            if (index < 0) {
                index = -(index + 1);
            }
            upperBounds.add(index);
        }

        return upperBounds;
    }
}