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
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int upperBound = 0;

            for (int j = 0; j < keys.size(); j++) {
                if (i == j) continue;
                if (currentKey.compareTo(keys.get(j)) < 0) {
                    upperBound++;
                }
            }

            upperBounds.add(upperBound);
        }

        return upperBounds;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        UpperBoundCalculator<Integer> calculator = new UpperBoundCalculator<>();
        List<Integer> keys = List.of(1, 3, 2, 4);
        List<Integer> upperBounds = calculator.computeUpperBounds(keys);
        System.out.println(upperBounds); // Output: [0, 2, 1, 3]
    }
}