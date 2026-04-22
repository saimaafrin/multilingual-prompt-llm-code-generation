import java.util.*;

public class BoundComputer<K extends Comparable<K>> {

    /**
     * Finds a minimum lower bound for every key.
     * @param keys a list of keys.
     * @return the computed key upper bound.
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> upperBounds = new ArrayList<>(keys.size());
        
        // Initialize all upper bounds to the size of the list
        for (int i = 0; i < keys.size(); i++) {
            upperBounds.add(keys.size());
        }

        // For each key, find its upper bound by comparing with all other keys
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            for (int j = 0; j < keys.size(); j++) {
                if (i != j && currentKey.compareTo(keys.get(j)) <= 0) {
                    upperBounds.set(i, Math.min(upperBounds.get(i), j));
                }
            }
        }

        return upperBounds;
    }
}