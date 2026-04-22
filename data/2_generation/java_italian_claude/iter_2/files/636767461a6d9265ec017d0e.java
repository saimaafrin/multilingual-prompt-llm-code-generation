import java.util.*;

public class SuffixSumCalculator {

    private static class Pair<T1, T2> {
        private T1 first;
        private T2 second;
        
        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }

    private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
        if (bounds == null || bounds.isEmpty()) {
            return new Pair<>(new ArrayList<>(), 0L);
        }

        List<Integer> suffixSums = new ArrayList<>(bounds.size());
        long totalSum = 0;
        
        // Calculate total sum first
        for (int num : bounds) {
            totalSum += num;
        }
        
        // Calculate suffix sums
        long currentSum = 0;
        for (int i = bounds.size() - 1; i >= 0; i--) {
            currentSum += bounds.get(i);
            suffixSums.add(0, (int)currentSum);
        }

        return new Pair<>(suffixSums, totalSum);
    }
}