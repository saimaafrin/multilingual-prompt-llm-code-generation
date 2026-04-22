import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UpperBoundCalculator<K extends Comparable<K>> {

    /**
     * Finds a minimum lower bound for every key.
     * @param keys a list of keys.
     * @return the computed key upper bound.
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> upperBounds = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            int upperBound = 0;
            for (int j = 0; j < keys.size(); j++) {
                if (i != j && keys.get(j).compareTo(keys.get(i)) < 0) {
                    upperBound++;
                }
            }
            upperBounds.add(upperBound);
        }

        return upperBounds;
    }
}