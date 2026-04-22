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

        // Sort the keys to find the minimum lower bound for each key
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        List<Integer> upperBounds = new ArrayList<>();
        for (int i = 0; i < sortedKeys.size(); i++) {
            // The upper bound for each key is the index of the next key in the sorted list
            upperBounds.add(i + 1);
        }

        return upperBounds;
    }
}