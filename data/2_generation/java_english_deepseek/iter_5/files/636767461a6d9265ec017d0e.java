import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.lang3.tuple.Pair;

private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
    if (bounds == null || bounds.isEmpty()) {
        return Pair.of(Collections.emptyList(), 0L);
    }

    List<Integer> suffixSums = new ArrayList<>(bounds.size());
    long totalSum = 0;

    // Calculate the total sum of all elements
    for (int num : bounds) {
        totalSum += num;
    }

    // Compute suffix sums
    long suffixSum = 0;
    for (int i = bounds.size() - 1; i >= 0; i--) {
        suffixSum += bounds.get(i);
        suffixSums.add(0, (int) suffixSum); // Insert at the beginning to maintain order
    }

    return Pair.of(suffixSums, totalSum);
}