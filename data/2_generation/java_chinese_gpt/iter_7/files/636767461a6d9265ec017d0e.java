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
        List<Integer> suffixSum = new ArrayList<>();
        long totalSum = 0;
        
        // Calculate total sum and suffix sums
        for (int i = bounds.size() - 1; i >= 0; i--) {
            totalSum += bounds.get(i);
            if (i == bounds.size() - 1) {
                suffixSum.add(bounds.get(i));
            } else {
                suffixSum.add(bounds.get(i) + suffixSum.get(suffixSum.size() - 1));
            }
        }
        
        // Reverse the suffix sum list to maintain the original order
        List<Integer> reversedSuffixSum = new ArrayList<>();
        for (int i = suffixSum.size() - 1; i >= 0; i--) {
            reversedSuffixSum.add(suffixSum.get(i));
        }
        
        return new Pair<>(reversedSuffixSum, totalSum);
    }
}