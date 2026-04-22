import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javafx.util.Pair;

private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
    if (bounds == null || bounds.isEmpty()) {
        return new Pair<>(Collections.emptyList(), 0L);
    }

    List<Integer> suffixSums = new ArrayList<>(bounds.size());
    long totalSum = 0;
    int currentSum = 0;

    // 计算后缀和
    for (int i = bounds.size() - 1; i >= 0; i--) {
        currentSum += bounds.get(i);
        suffixSums.add(currentSum);
    }

    // 反转后缀和列表以保持原始顺序
    Collections.reverse(suffixSums);

    // 计算总和
    for (int num : bounds) {
        totalSum += num;
    }

    return new Pair<>(suffixSums, totalSum);
}