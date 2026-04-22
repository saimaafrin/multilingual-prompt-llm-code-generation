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

        // Ordina le chiavi per trovare i limiti superiori
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        List<Integer> upperBounds = new ArrayList<>();
        for (K key : keys) {
            // Trova l'indice della chiave nella lista ordinata
            int index = Collections.binarySearch(sortedKeys, key);
            if (index < 0) {
                // Se la chiave non è presente, il limite superiore è l'indice di inserimento
                index = -index - 1;
            } else {
                // Se la chiave è presente, il limite superiore è l'indice successivo
                index++;
            }

            // Se l'indice è fuori dai limiti, il limite superiore è la dimensione della lista
            if (index >= sortedKeys.size()) {
                upperBounds.add(sortedKeys.size());
            } else {
                upperBounds.add(index);
            }
        }

        return upperBounds;
    }
}