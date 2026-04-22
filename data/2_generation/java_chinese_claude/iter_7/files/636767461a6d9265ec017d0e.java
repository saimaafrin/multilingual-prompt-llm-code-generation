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
        long total = 0;
        
        // 计算总和
        for (int num : bounds) {
            total += num;
        }
        
        // 计算后缀和
        long currentSum = 0;
        for (int i = bounds.size() - 1; i >= 0; i--) {
            currentSum += bounds.get(i);
            suffixSum.add(0, (int)currentSum);
        }
        
        return new Pair<>(suffixSum, total);
    }
}