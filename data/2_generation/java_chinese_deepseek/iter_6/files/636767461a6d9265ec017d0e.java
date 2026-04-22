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
    int currentSuffixSum = 0;

    // 计算后缀和
    for (int i = bounds.size() - 1; i >= 0; i--) {
        currentSuffixSum += bounds.get(i);
        suffixSums.add(currentSuffixSum);
    }

    // 反转后缀和列表以保持原始顺序
    Collections.reverse(suffixSums);

    // 计算总和
    for (int num : bounds) {
        totalSum += num;
    }

    return Pair.of(suffixSums, totalSum);
}