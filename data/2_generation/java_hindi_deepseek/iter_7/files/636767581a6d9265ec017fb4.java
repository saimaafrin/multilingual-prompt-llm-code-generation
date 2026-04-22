import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class UpperBoundCalculator<K extends Comparable<K>> {

    /**
     * प्रत्येक कुंजी के लिए एक न्यूनतम ऊपरी सीमा खोजता है।
     * @param keys कुंजियों की एक सूची।
     * @return गणना की गई कुंजी की ऊपरी सीमा।
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        List<Integer> upperBounds = new ArrayList<>();
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        for (K key : keys) {
            int index = Collections.binarySearch(sortedKeys, key);
            if (index < 0) {
                // If the key is not found, calculate the insertion point
                index = -index - 1;
            }
            upperBounds.add(index);
        }

        return upperBounds;
    }
}