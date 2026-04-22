import java.util.List;
import java.util.ArrayList;
import javafx.util.Pair;

private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
    List<Integer> suffixSums = new ArrayList<>();
    long totalSum = 0;
    
    // Calculate the suffix sums
    int suffixSum = 0;
    for (int i = bounds.size() - 1; i >= 0; i--) {
        suffixSum += bounds.get(i);
        suffixSums.add(0, suffixSum); // Add to the beginning of the list
    }
    
    // Calculate the total sum of all elements
    for (int num : bounds) {
        totalSum += num;
    }
    
    return new Pair<>(suffixSums, totalSum);
}