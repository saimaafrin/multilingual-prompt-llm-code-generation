import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

private List<Integer> computeLowerBounds(List<K> keys) {
    if (keys == null || keys.isEmpty()) {
        return Collections.emptyList();
    }

    List<Integer> lowerBounds = new ArrayList<>();
    int currentLowerBound = Integer.MIN_VALUE;

    for (K key : keys) {
        // Assuming K is a type that can be compared or has a method to get a comparable value
        // For example, if K is Integer, you can directly compare
        // If K is a custom object, you might need to implement Comparable or use a specific method
        int keyValue = key.hashCode(); // Placeholder for actual value extraction logic

        if (keyValue > currentLowerBound) {
            currentLowerBound = keyValue;
        }
        lowerBounds.add(currentLowerBound);
    }

    return lowerBounds;
}