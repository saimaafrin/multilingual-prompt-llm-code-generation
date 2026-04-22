import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

private List<Integer> computeLowerBounds(List<K> keys) {
    List<Integer> lowerBounds = new ArrayList<>();
    if (keys == null || keys.isEmpty()) {
        return lowerBounds;
    }

    // Assuming K is a comparable type, we can sort the keys and find the lower bounds
    List<K> sortedKeys = new ArrayList<>(keys);
    Collections.sort(sortedKeys);

    // The lower bound for the first element is itself
    lowerBounds.add((Integer) sortedKeys.get(0));

    // For the rest of the elements, the lower bound is the previous element
    for (int i = 1; i < sortedKeys.size(); i++) {
        lowerBounds.add((Integer) sortedKeys.get(i - 1));
    }

    return lowerBounds;
}