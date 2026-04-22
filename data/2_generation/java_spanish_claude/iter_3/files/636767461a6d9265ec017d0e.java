import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class SuffixSumCalculator {

    /**
     * Calcula una suma de sufijos de los {@code bounds}. Devuelve la suma de sufijos calculada y la suma de todos los elementos en la {@code lista de bounds}.
     * @param bounds lista de enteros.
     * @return par calculado de la lista de suma de sufijos y la suma de todos los elementos.
     */
    private Pair<List<Integer>,Long> computeSuffixSum(List<Integer> bounds) {
        List<Integer> suffixSums = new ArrayList<>();
        long totalSum = 0;
        
        // Calculate total sum first
        for (int num : bounds) {
            totalSum += num;
        }
        
        // Calculate suffix sums
        long currentSum = 0;
        for (int i = bounds.size() - 1; i >= 0; i--) {
            currentSum += bounds.get(i);
            suffixSums.add(0, (int)currentSum);
        }
        
        return new Pair<>(suffixSums, totalSum);
    }
}