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
        if (keys == null || keys.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> upperBounds = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int upperBound = Integer.MAX_VALUE;

            for (int j = i + 1; j < keys.size(); j++) {
                if (currentKey.compareTo(keys.get(j)) < 0) {
                    upperBound = j;
                    break;
                }
            }

            upperBounds.add(upperBound);
        }

        return upperBounds;
    }
}