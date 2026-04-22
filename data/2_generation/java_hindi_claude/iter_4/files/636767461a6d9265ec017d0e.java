import java.util.ArrayList;
import java.util.List;

public class SuffixSum {
    public static Pair<List<Integer>, Integer> computeSuffixSum(List<Integer> bounds) {
        if (bounds == null || bounds.isEmpty()) {
            return new Pair<>(new ArrayList<>(), 0);
        }

        int totalSum = 0;
        List<Integer> suffixSum = new ArrayList<>(bounds.size());

        // Fill suffix sum array with 0s initially
        for (int i = 0; i < bounds.size(); i++) {
            suffixSum.add(0);
        }

        // Calculate total sum and last element of suffix sum
        for (int num : bounds) {
            totalSum += num;
        }

        // Calculate suffix sum
        suffixSum.set(bounds.size() - 1, bounds.get(bounds.size() - 1));
        for (int i = bounds.size() - 2; i >= 0; i--) {
            suffixSum.set(i, suffixSum.get(i + 1) + bounds.get(i));
        }

        return new Pair<>(suffixSum, totalSum);
    }
}

// Helper class to return pair of values
class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}