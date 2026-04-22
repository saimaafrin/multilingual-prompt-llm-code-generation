import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LowerBoundsCalculator<K extends Comparable<K>> {

    /**
     * प्रत्येक कुंजी के लिए अधिकतम निम्न सीमा खोजता है।
     * @param keys कुंजी की सूची।
     * @return गणना की गई कुंजी की निम्न सीमाएँ।
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        List<Integer> lowerBounds = new ArrayList<>();
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        for (K key : keys) {
            int index = Collections.binarySearch(sortedKeys, key);
            if (index < 0) {
                // If the key is not found, calculate the insertion point
                index = -index - 1;
            }
            lowerBounds.add(index);
        }

        return lowerBounds;
    }
}