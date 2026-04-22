import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

private List<Integer> computeUpperBounds(List<K> keys) {
    List<Integer> upperBounds = new ArrayList<>();
    if (keys == null || keys.isEmpty()) {
        return upperBounds;
    }

    // Assuming K is a type that can be compared, e.g., Integer, String, etc.
    // We need to find the smallest element that is greater than or equal to each key.
    // For simplicity, let's assume K is Comparable.
    List<K> sortedKeys = new ArrayList<>(keys);
    Collections.sort(sortedKeys);

    for (K key : keys) {
        int index = Collections.binarySearch(sortedKeys, key);
        if (index >= 0) {
            // If the key is found, the upper bound is the key itself.
            upperBounds.add((Integer) key);
        } else {
            // If the key is not found, the insertion point is returned as (-(insertion point) - 1).
            int insertionPoint = -index - 1;
            if (insertionPoint < sortedKeys.size()) {
                upperBounds.add((Integer) sortedKeys.get(insertionPoint));
            } else {
                // If the insertion point is beyond the list, there is no upper bound.
                upperBounds.add(null);
            }
        }
    }

    return upperBounds;
}