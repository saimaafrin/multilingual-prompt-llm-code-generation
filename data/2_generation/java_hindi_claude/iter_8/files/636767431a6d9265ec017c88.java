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
        for (int key : keys) {
            int maxLowerBound = Integer.MIN_VALUE;
            
            for (int possibleBound : keys) {
                if (possibleBound < key && possibleBound > maxLowerBound) {
                    maxLowerBound = possibleBound;
                }
            }
            
            // Only add if we found a valid lower bound
            if (maxLowerBound != Integer.MIN_VALUE) {
                lowerBounds.put(key, maxLowerBound);
            }
        }
        
        return lowerBounds;
    }
}