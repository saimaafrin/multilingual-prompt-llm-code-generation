import java.util.*;

public class BoundCalculator<K extends Comparable<K>> {

    /**
     * Trova un limite superiore minimo per ogni chiave.
     * @param keys una lista di chiavi.
     * @return il limite superiore delle chiavi calcolato.
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> upperBounds = new ArrayList<>(keys.size());
        
        // Per ogni chiave, trova il suo limite superiore
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int upperBound = i;
            
            // Confronta con tutte le chiavi successive
            for (int j = i + 1; j < keys.size(); j++) {
                if (currentKey.compareTo(keys.get(j)) <= 0) {
                    upperBound = j;
                }
            }
            
            upperBounds.add(upperBound);
        }
        
        return upperBounds;
    }
}