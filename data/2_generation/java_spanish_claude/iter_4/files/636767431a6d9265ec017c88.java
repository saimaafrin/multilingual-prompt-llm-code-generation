import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class BoundCalculator<K extends Comparable<K>> {

    /**
     * Encuentra un límite inferior máximo para cada llave.
     * @param keys lista de llaves.
     * @return los límites inferiores de llaves calculados.
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> lowerBounds = new ArrayList<>(keys.size());
        
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int maxLowerBound = 0;
            
            for (int j = 0; j < i; j++) {
                K previousKey = keys.get(j);
                if (previousKey.compareTo(currentKey) <= 0) {
                    maxLowerBound = Math.max(maxLowerBound, lowerBounds.get(j) + 1);
                }
            }
            
            lowerBounds.add(maxLowerBound);
        }
        
        return lowerBounds;
    }
}