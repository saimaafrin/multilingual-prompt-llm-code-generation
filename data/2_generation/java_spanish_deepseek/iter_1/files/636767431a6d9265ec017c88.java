import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LowerBoundsCalculator<K extends Comparable<K>> {

    /**
     * Encuentra un límite inferior máximo para cada llave.
     * @param keys lista de llaves.
     * @return los límites inferiores de llaves calculados.
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> lowerBounds = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int lowerBound = 0;

            for (int j = 0; j < i; j++) {
                if (keys.get(j).compareTo(currentKey) < 0) {
                    lowerBound++;
                }
            }

            lowerBounds.add(lowerBound);
        }

        return lowerBounds;
    }
}