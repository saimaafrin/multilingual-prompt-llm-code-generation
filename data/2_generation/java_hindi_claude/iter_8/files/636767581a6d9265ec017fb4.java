import java.util.List;

public class KeyBoundCalculator {
    /**
     * Finds a minimum lower bound for every key.
     * @param keys a list of keys.
     * @return the computed key upper bound.
     */
    public static int findMinLowerBound(List<Integer> keys) {
        if (keys == null || keys.isEmpty()) {
            return 0;
        }

        int minBound = Integer.MAX_VALUE;
        
        for (Integer key : keys) {
            if (key != null && key < minBound) {
                minBound = key;
            }
        }

        return minBound;
    }
}