import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

private List<Integer> computeLowerBounds(List<K> keys) {
    if (keys == null || keys.isEmpty()) {
        return Collections.emptyList();
    }

    List<Integer> lowerBounds = new ArrayList<>();
    int currentMax = Integer.MIN_VALUE;

    for (K key : keys) {
        if (key == null) {
            lowerBounds.add(null);
        } else {
            currentMax = Math.max(currentMax, key.hashCode());
            lowerBounds.add(currentMax);
        }
    }

    return lowerBounds;
}