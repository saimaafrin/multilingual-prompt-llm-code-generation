import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class SuffixSumCalculator {
    /**
     * 计算 {@code bounds} 的后缀和。返回计算出的后缀和和 {@code bounds list} 中所有元素的总和。
     * @param bounds 整数列表。
     * @return 计算出的后缀和列表和所有元素的总和的配对。
     */
    private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
        List<Integer> suffixSums = new ArrayList<>();
        long totalSum = 0;
        
        // Handle empty list case
        if (bounds == null || bounds.isEmpty()) {
            return new Pair<>(suffixSums, totalSum);
        }

        // Calculate total sum first
        for (int num : bounds) {
            totalSum += num;
        }

        // Calculate suffix sums
        int currentSum = 0;
        for (int i = bounds.size() - 1; i >= 0; i--) {
            currentSum += bounds.get(i);
            suffixSums.add(0, currentSum); // Add at beginning to maintain order
        }

        return new Pair<>(suffixSums, totalSum);
    }
}