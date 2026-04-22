import java.util.*;

public class LowerBoundsCalculator<K extends Comparable<K>> {

    /**
     * Finds a maximum lower bound for every key.
     * @param keys list of keys.
     * @return the computed key lower bounds.
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> lowerBounds = new ArrayList<>();
        TreeSet<K> sortedKeys = new TreeSet<>(keys);

        for (K key : keys) {
            K lowerBound = sortedKeys.lower(key);
            if (lowerBound != null) {
                lowerBounds.add(lowerBound.hashCode());
            } else {
                lowerBounds.add(Integer.MIN_VALUE); // No lower bound found
            }
        }

        return lowerBounds;
    }

    public static void main(String[] args) {
        LowerBoundsCalculator<Integer> calculator = new LowerBoundsCalculator<>();
        List<Integer> keys = Arrays.asList(5, 3, 8, 1, 4);
        List<Integer> lowerBounds = calculator.computeLowerBounds(keys);
        System.out.println(lowerBounds); // Example output: [4, 1, 5, -2147483648, 3]
    }
}