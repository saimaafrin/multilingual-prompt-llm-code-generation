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
            return new ArrayList<>();
        }

        List<Integer> lowerBounds = new ArrayList<>(keys.size());
        
        // Para cada llave, encontrar su límite inferior
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int lowerBound = 0;
            
            // Comparar con todas las llaves anteriores
            for (int j = 0; j < i; j++) {
                if (keys.get(j).compareTo(currentKey) <= 0) {
                    lowerBound = Math.max(lowerBound, j + 1);
                }
            }
            
            lowerBounds.add(lowerBound);
        }

        return lowerBounds;
    }
}