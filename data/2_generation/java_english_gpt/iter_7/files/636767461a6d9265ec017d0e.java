import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class SuffixSumCalculator {

    /** 
     * Computes a suffix sum of the {@code bounds}. Returns computed suffix sum and the sum of all elements in the {@code bounds list}.
     * @param bounds list of integers.
     * @return computed pair of suffix sum list and a sum of all elements.
     */
    private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
        long totalSum = 0;
        List<Integer> suffixSum = new ArrayList<>();
        
        // Calculate total sum and suffix sums
        for (int i = bounds.size() - 1; i >= 0; i--) {
            totalSum += bounds.get(i);
            suffixSum.add(0, totalSum); // Add to the front to maintain order
        }
        
        return new Pair<>(suffixSum, totalSum);
    }
}