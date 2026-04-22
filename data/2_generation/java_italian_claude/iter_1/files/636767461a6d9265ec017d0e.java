import java.util.*;

public class SuffixSumCalculator {

    private static class Pair<T,U> {
        private T first;
        private U second;
        
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

    /**
     * Calcola la somma dei suffissi di {@code bounds}. Restituisce la somma dei suffissi calcolata e la somma totale di tutti gli elementi nella lista {@code bounds}.
     * @param bounds lista di interi.
     * @return coppia calcolata di lista di somma suffisso e somma di tutti gli elementi.
     */
    private Pair<List<Integer>,Long> computeSuffixSum(List<Integer> bounds) {
        if (bounds == null || bounds.isEmpty()) {
            return new Pair<>(new ArrayList<>(), 0L);
        }

        int n = bounds.size();
        List<Integer> suffixSums = new ArrayList<>(n);
        long totalSum = 0;
        
        // Calculate the last suffix sum first (which is just the last element)
        suffixSums.add(bounds.get(n-1));
        totalSum = bounds.get(n-1);
        
        // Calculate remaining suffix sums from right to left
        for (int i = n-2; i >= 0; i--) {
            int currentSuffixSum = bounds.get(i) + suffixSums.get(suffixSums.size()-1);
            suffixSums.add(0, currentSuffixSum);
            totalSum += bounds.get(i);
        }
        
        return new Pair<>(suffixSums, totalSum);
    }
}