import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class KeyBounds {

    /**
     * Finds a minimum lower bound for every key.
     * @param keys a list of keys.
     * @return the computed key upper bound.
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> upperBounds = new ArrayList<>();
        int currentMax = Integer.MIN_VALUE;

        for (K key : keys) {
            int keyValue = key.hashCode(); // Assuming K has a hashCode method
            if (keyValue > currentMax) {
                currentMax = keyValue;
            }
            upperBounds.add(currentMax);
        }

        return upperBounds;
    }
}