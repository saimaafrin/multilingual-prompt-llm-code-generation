import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

private List<Integer> computeUpperBounds(List<K> keys) {
    List<Integer> upperBounds = new ArrayList<>();
    if (keys == null || keys.isEmpty()) {
        return upperBounds;
    }

    // Assuming K is a Comparable type, we can sort the keys
    List<K> sortedKeys = new ArrayList<>(keys);
    Collections.sort(sortedKeys);

    // The upper bound for each key is the next key in the sorted list
    for (int i = 0; i < sortedKeys.size() - 1; i++) {
        upperBounds.add((Integer) sortedKeys.get(i + 1));
    }

    // The last key has no upper bound, so we can add a special value (e.g., Integer.MAX_VALUE)
    upperBounds.add(Integer.MAX_VALUE);

    return upperBounds;
}