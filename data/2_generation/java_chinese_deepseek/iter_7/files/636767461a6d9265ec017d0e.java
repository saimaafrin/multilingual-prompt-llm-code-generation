import java.util.List;
import java.util.ArrayList;
import javafx.util.Pair;

private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
    List<Integer> suffixSums = new ArrayList<>();
    long totalSum = 0;
    
    // 计算总和
    for (int num : bounds) {
        totalSum += num;
    }
    
    // 计算后缀和
    long suffixSum = 0;
    for (int i = bounds.size() - 1; i >= 0; i--) {
        suffixSum += bounds.get(i);
        suffixSums.add(0, (int) suffixSum);
    }
    
    return new Pair<>(suffixSums, totalSum);
}