import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class UpperBoundCalculator<K extends Comparable<K>> {

    /**
     * Trova un limite superiore minimo per ogni chiave.
     * @param keys una lista di chiavi.
     * @return il limite superiore delle chiavi calcolato.
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return new ArrayList<>();
        }

        // Ordina la lista di chiavi
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        List<Integer> upperBounds = new ArrayList<>();
        for (K key : keys) {
            // Trova l'indice della chiave nella lista ordinata
            int index = Collections.binarySearch(sortedKeys, key);
            if (index < 0) {
                // Se la chiave non è presente, Collections.binarySearch restituisce (-(insertion point) - 1)
                index = -index - 1;
            }
            // Il limite superiore è l'elemento successivo nella lista ordinata
            if (index < sortedKeys.size()) {
                upperBounds.add((Integer) sortedKeys.get(index));
            } else {
                // Se non c'è un elemento successivo, il limite superiore è nullo o un valore predefinito
                upperBounds.add(null);
            }
        }

        return upperBounds;
    }
}