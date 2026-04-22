import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        for (K key : keys) {
            int index = Collections.binarySearch(sortedKeys, key);
            if (index < 0) {
                // Se la chiave non è presente, Collections.binarySearch restituisce (-(insertion point) - 1)
                index = -index - 1;
            }
            lowerBounds.add(index);
        }

        return lowerBounds;
    }
}