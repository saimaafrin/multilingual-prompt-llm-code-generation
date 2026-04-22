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

        // Calculate total sum and suffix sums
        for (int i = bounds.size() - 1; i >= 0; i--) {
            totalSum += bounds.get(i);
            suffixSums.add(0, totalSum); // Add to the front to maintain order
        }

        return new Pair<>(suffixSums, totalSum);
    }
}