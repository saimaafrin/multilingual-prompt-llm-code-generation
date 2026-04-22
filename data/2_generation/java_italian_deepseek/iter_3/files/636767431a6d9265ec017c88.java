import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LowerBoundsCalculator<K extends Comparable<K>> {

    /**
     * Trova un limite inferiore massimo per ogni chiave.
     * @param keys lista delle chiavi.
     * @return i limiti inferiori delle chiavi calcolati.
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> lowerBounds = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int lowerBound = 0;

            for (int j = 0; j < keys.size(); j++) {
                if (i == j) continue;
                if (keys.get(j).compareTo(currentKey) < 0) {
                    lowerBound++;
                }
            }

            lowerBounds.add(lowerBound);
        }

        return lowerBounds;
    }

    public static void main(String[] args) {
        LowerBoundsCalculator<Integer> calculator = new LowerBoundsCalculator<>();
        List<Integer> keys = List.of(5, 3, 9, 1, 7);
        List<Integer> lowerBounds = calculator.computeLowerBounds(keys);
        System.out.println(lowerBounds); // Output: [2, 1, 4, 0, 3]
    }
}