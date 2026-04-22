import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.lang3.tuple.Pair;

private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
    if (bounds == null || bounds.isEmpty()) {
        return Pair.of(Collections.emptyList(), 0L);
    }

    List<Integer> suffixSum = new ArrayList<>(bounds.size());
    long totalSum = 0;

    // Compute the suffix sum
    int currentSum = 0;
    for (int i = bounds.size() - 1; i >= 0; i--) {
        currentSum += bounds.get(i);
        suffixSum.add(currentSum);
    }

    // Reverse the suffix sum list to match the original order
    Collections.reverse(suffixSum);

    // Compute the total sum of all elements
    for (int num : bounds) {
        totalSum += num;
    }

    return Pair.of(suffixSum, totalSum);
}