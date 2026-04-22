import java.util.ArrayList;
import java.util.List;

public class UpperBoundCalculator<K extends Comparable<K>> {

    /** 
     * प्रत्येक कुंजी के लिए एक न्यूनतम ऊपरी सीमा खोजता है।
     * @param keys कुंजियों की एक सूची।
     * @return गणना की गई कुंजी की ऊपरी सीमा।
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        List<Integer> upperBounds = new ArrayList<>();
        for (K key : keys) {
            // Assuming the upper bound is the index of the next greater element
            int upperBound = findUpperBound(key, keys);
            upperBounds.add(upperBound);
        }
        return upperBounds;
    }

    private int findUpperBound(K key, List<K> keys) {
        int low = 0, high = keys.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (keys.get(mid).compareTo(key) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low < keys.size() ? low : -1; // Return -1 if no upper bound found
    }
}