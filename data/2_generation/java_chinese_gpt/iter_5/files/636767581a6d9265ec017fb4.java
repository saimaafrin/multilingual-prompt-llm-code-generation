import java.util.ArrayList;
import java.util.List;

public class UpperBoundCalculator<K extends Comparable<K>> {

    /** 
     * 为每个键找到一个最小上界。
     * @param keys 键的列表。
     * @return 计算得到的键上界。
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        List<Integer> upperBounds = new ArrayList<>();
        if (keys == null || keys.isEmpty()) {
            return upperBounds;
        }

        for (K key : keys) {
            int upperBound = findUpperBound(key, keys);
            upperBounds.add(upperBound);
        }
        return upperBounds;
    }

    private int findUpperBound(K key, List<K> keys) {
        int upperBound = Integer.MAX_VALUE;
        for (K k : keys) {
            if (k.compareTo(key) > 0) {
                upperBound = Math.min(upperBound, (Integer) k);
            }
        }
        return upperBound == Integer.MAX_VALUE ? -1 : upperBound; // Return -1 if no upper bound found
    }
}