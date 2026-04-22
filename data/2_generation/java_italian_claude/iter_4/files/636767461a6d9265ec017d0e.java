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
        int currentSuffixSum = 0;

        // Calculate suffix sums from right to left
        for (int i = bounds.size() - 1; i >= 0; i--) {
            currentSuffixSum += bounds.get(i);
            suffixSums.add(0, currentSuffixSum);
            totalSum += bounds.get(i);
        }

        return new Pair<>(suffixSums, totalSum);
    }
}