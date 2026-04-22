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

            for (int j = 0; j < keys.size(); j++) {
                if (i == j) continue;
                K otherKey = keys.get(j);
                if (currentKey.compareTo(otherKey) < 0) {
                    upperBound = Math.min(upperBound, otherKey.hashCode());
                }
            }

            upperBounds.add(upperBound == Integer.MAX_VALUE ? -1 : upperBound);
        }

        return upperBounds;
    }
}