import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.lang3.tuple.Pair;

private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
    // Calculate the total sum of all elements in the list
    long totalSum = bounds.stream().mapToLong(Integer::longValue).sum();

    // Calculate the suffix sums
    List<Integer> suffixSums = new ArrayList<>();
    int currentSum = 0;
    for (int i = bounds.size() - 1; i >= 0; i--) {
        currentSum += bounds.get(i);
        suffixSums.add(currentSum);
    }
    // Reverse the list to get the suffix sums in the original order
    Collections.reverse(suffixSums);

    // Return the pair of suffix sums and total sum
    return Pair.of(suffixSums, totalSum);
}