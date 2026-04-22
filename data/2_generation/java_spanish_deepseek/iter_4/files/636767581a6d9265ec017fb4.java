import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class UpperBoundCalculator<K extends Comparable<K>> {

    /**
     * Encuentra un límite superior mínimo para cada clave.
     * @param keys una lista de claves.
     * @return el límite superior de clave calculado.
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> upperBounds = new ArrayList<>();
        for (K key : keys) {
            int upperBound = findUpperBound(keys, key);
            upperBounds.add(upperBound);
        }

        return upperBounds;
    }

    /**
     * Encuentra el límite superior para una clave dada.
     * @param keys la lista de claves.
     * @param key la clave para la cual se busca el límite superior.
     * @return el límite superior de la clave.
     */
    private int findUpperBound(List<K> keys, K key) {
        int low = 0;
        int high = keys.size() - 1;
        int result = keys.size();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (keys.get(mid).compareTo(key) > 0) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}