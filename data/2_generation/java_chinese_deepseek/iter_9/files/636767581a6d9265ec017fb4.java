import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class UpperBoundCalculator<K extends Comparable<K>> {

    /**
     * 为每个键找到一个最小上界。
     * @param keys 键的列表。
     * @return 计算得到的键上界。
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> upperBounds = new ArrayList<>();
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        for (K key : keys) {
            int index = Collections.binarySearch(sortedKeys, key);
            if (index >= 0) {
                // If the key is found, the upper bound is the next element
                if (index < sortedKeys.size() - 1) {
                    upperBounds.add(index + 1);
                } else {
                    // If it's the last element, there is no upper bound
                    upperBounds.add(-1);
                }
            } else {
                // If the key is not found, the insertion point is the upper bound
                int insertionPoint = -index - 1;
                if (insertionPoint < sortedKeys.size()) {
                    upperBounds.add(insertionPoint);
                } else {
                    upperBounds.add(-1);
                }
            }
        }

        return upperBounds;
    }
}