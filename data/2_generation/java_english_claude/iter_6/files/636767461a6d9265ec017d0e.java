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
        List<Integer> suffixSum = new ArrayList<>();
        long totalSum = 0;
        
        // Calculate total sum first
        for (int num : bounds) {
            totalSum += num;
        }
        
        // Calculate suffix sums
        long currentSum = 0;
        for (int i = bounds.size() - 1; i >= 0; i--) {
            currentSum += bounds.get(i);
            suffixSum.add(0, (int)currentSum);
        }
        
        return new Pair<>(suffixSum, totalSum);
    }
}