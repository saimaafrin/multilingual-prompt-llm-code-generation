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

    // Compute the total sum and initialize the suffix sum list
    for (int i = bounds.size() - 1; i >= 0; i--) {
        totalSum += bounds.get(i);
        suffixSum.add((int) totalSum);
    }

    // Reverse the suffix sum list to get the correct order
    Collections.reverse(suffixSum);

    return Pair.of(suffixSum, totalSum);
}