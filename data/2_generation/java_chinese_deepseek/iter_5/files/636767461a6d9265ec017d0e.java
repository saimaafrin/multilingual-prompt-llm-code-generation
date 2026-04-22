import java.util.List;
import java.util.ArrayList;
import javafx.util.Pair;

public class SuffixSumCalculator {

    /**
     * 计算 {@code bounds} 的后缀和。返回计算出的后缀和和 {@code bounds list} 中所有元素的总和。
     * @param bounds 整数列表。
     * @return 计算出的后缀和列表和所有元素的总和的配对。
     */
    private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
        if (bounds == null || bounds.isEmpty()) {
            return new Pair<>(new ArrayList<>(), 0L);
        }

        List<Integer> suffixSums = new ArrayList<>();
        long totalSum = 0;
        int currentSum = 0;

        // 计算后缀和
        for (int i = bounds.size() - 1; i >= 0; i--) {
            currentSum += bounds.get(i);
            suffixSums.add(0, currentSum); // 在列表开头插入当前后缀和
            totalSum += bounds.get(i);
        }

        return new Pair<>(suffixSums, totalSum);
    }

    public static void main(String[] args) {
        SuffixSumCalculator calculator = new SuffixSumCalculator();
        List<Integer> bounds = List.of(1, 2, 3, 4);
        Pair<List<Integer>, Long> result = calculator.computeSuffixSum(bounds);
        System.out.println("Suffix Sums: " + result.getKey());
        System.out.println("Total Sum: " + result.getValue());
    }
}