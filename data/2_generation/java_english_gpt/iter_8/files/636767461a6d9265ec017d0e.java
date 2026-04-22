import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class SuffixSumCalculator {

    /** 
     * Computes a suffix sum of the  {@code bounds}. Returns computed suffix sum and the sum of all elements in the  {@code bounds list}.
     * @param bounds list of integers.
     * @return computed pair of suffix sum list and a sum of all elements.
     */
    private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
        List<Integer> suffixSum = new ArrayList<>();
        long totalSum = 0;
        int currentSuffixSum = 0;

        // Calculate total sum and suffix sums
        for (int i = bounds.size() - 1; i >= 0; i--) {
            currentSuffixSum += bounds.get(i);
            suffixSum.add(currentSuffixSum);
            totalSum += bounds.get(i);
        }

        // Reverse the suffix sum list to maintain the original order
        List<Integer> reversedSuffixSum = new ArrayList<>();
        for (int i = suffixSum.size() - 1; i >= 0; i--) {
            reversedSuffixSum.add(suffixSum.get(i));
        }

        return new Pair<>(reversedSuffixSum, totalSum);
    }
}