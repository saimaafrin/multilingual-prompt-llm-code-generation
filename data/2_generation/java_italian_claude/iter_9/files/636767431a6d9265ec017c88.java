import java.util.*;

public class BoundCalculator<K extends Comparable<K>> {

    /**
     * Trova un limite inferiore massimo per ogni chiave.
     * @param keys lista delle chiavi.
     * @return i limiti inferiori delle chiavi calcolati.
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> lowerBounds = new ArrayList<>(keys.size());
        
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int maxLowerBound = 0;
            
            for (int j = 0; j < i; j++) {
                K previousKey = keys.get(j);
                if (currentKey.compareTo(previousKey) > 0) {
                    maxLowerBound = Math.max(maxLowerBound, lowerBounds.get(j) + 1);
                }
            }
            
            lowerBounds.add(maxLowerBound);
        }
        
        return lowerBounds;
    }
}