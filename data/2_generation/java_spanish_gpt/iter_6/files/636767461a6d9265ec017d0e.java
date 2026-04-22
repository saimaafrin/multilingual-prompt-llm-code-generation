import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class SuffixSumCalculator {

    /** 
     * Calcula una suma de sufijos de los {@code bounds}. Devuelve la suma de sufijos calculada y la suma de todos los elementos en la {@code lista de bounds}.
     * @param bounds lista de enteros.
     * @return par calculado de la lista de suma de sufijos y la suma de todos los elementos.
     */
    private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
        List<Integer> suffixSums = new ArrayList<>();
        long totalSum = 0;
        
        // Calculate total sum and suffix sums
        for (int i = bounds.size() - 1; i >= 0; i--) {
            totalSum += bounds.get(i);
            suffixSums.add(0, totalSum); // Add to the front to maintain order
        }
        
        return new Pair<>(suffixSums, totalSum);
    }
}