import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LowerBoundsCalculator<K> {

    /** 
     * Encuentra un límite inferior máximo para cada llave.
     * @param keys lista de llaves.
     * @return los límites inferiores de llaves calculados.
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        Map<K, Integer> lowerBoundsMap = new HashMap<>();
        List<Integer> lowerBounds = new ArrayList<>();

        for (K key : keys) {
            // Calculate the lower bound for each key (dummy logic for example)
            int lowerBound = key.hashCode() % 100; // Example calculation
            lowerBoundsMap.put(key, lowerBound);
        }

        for (K key : keys) {
            lowerBounds.add(lowerBoundsMap.get(key));
        }

        return lowerBounds;
    }
}