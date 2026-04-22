import java.util.*;

public class KeyBounds {
    /**
     * Finds a maximum lower bound for every key.
     * @param keys list of keys.
     * @return the computed key lower bounds.
     */
    public static Map<Integer, Integer> findKeyLowerBounds(List<Integer> keys) {
        // Sort keys in ascending order
        Collections.sort(keys);
        
        Map<Integer, Integer> lowerBounds = new HashMap<>();
        
        // For each key, find largest value less than it
        for (int i = 0; i < keys.size(); i++) {
            int currentKey = keys.get(i);
            
            // If first element, no lower bound exists
            if (i == 0) {
                lowerBounds.put(currentKey, null);
                continue;
            }
            
            // Get previous element as lower bound
            lowerBounds.put(currentKey, keys.get(i-1));
        }
        
        return lowerBounds;
    }
}