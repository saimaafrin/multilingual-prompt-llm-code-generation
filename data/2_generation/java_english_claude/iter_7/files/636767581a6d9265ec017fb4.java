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
        
        // For each key, find its upper bound
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int upperBound = i;
            
            // Compare with all subsequent keys
            for (int j = i + 1; j < keys.size(); j++) {
                if (currentKey.compareTo(keys.get(j)) > 0) {
                    upperBound = j;
                }
            }
            
            upperBounds.add(upperBound);
        }
        
        return upperBounds;
    }
}