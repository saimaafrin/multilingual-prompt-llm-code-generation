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
        
        // For each key, find the smallest value larger than it
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int upperBound = Integer.MAX_VALUE;
            
            for (int j = 0; j < keys.size(); j++) {
                if (i != j) {
                    K otherKey = keys.get(j);
                    if (currentKey.compareTo(otherKey) < 0) {
                        upperBound = Math.min(upperBound, j);
                    }
                }
            }
            
            upperBounds.add(upperBound);
        }
        
        return upperBounds;
    }
}