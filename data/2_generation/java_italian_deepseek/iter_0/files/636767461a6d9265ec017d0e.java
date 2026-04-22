import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SuffixSumCalculator {

    public static class Pair<A, B> {
        private final A first;
        private final B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }
    }

    private static Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
        if (bounds == null || bounds.isEmpty()) {
            return new Pair<>(Collections.emptyList(), 0L);
        }

        List<Integer> suffixSums = new ArrayList<>();
        long totalSum = 0;
        int currentSuffixSum = 0;

        // Calcola la somma totale e la somma dei suffissi
        for (int i = bounds.size() - 1; i >= 0; i--) {
            currentSuffixSum += bounds.get(i);
            suffixSums.add(currentSuffixSum);
            totalSum += bounds.get(i);
        }

        // Inverti la lista delle somme dei suffissi per avere l'ordine corretto
        Collections.reverse(suffixSums);

        return new Pair<>(suffixSums, totalSum);
    }

    public static void main(String[] args) {
        List<Integer> bounds = List.of(1, 2, 3, 4);
        Pair<List<Integer>, Long> result = computeSuffixSum(bounds);
        System.out.println("Suffix Sums: " + result.getFirst());
        System.out.println("Total Sum: " + result.getSecond());
    }
}