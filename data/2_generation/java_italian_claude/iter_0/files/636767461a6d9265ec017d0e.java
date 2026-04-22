import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class SuffixSumCalculator {

    /**
     * Calcola la somma dei suffissi di {@code bounds}. Restituisce la somma dei suffissi calcolata e la somma totale di tutti gli elementi nella lista {@code bounds}.
     * @param bounds lista di interi.
     * @return coppia calcolata di lista di somma suffisso e somma di tutti gli elementi.
     */
    private Pair<List<Integer>,Long> computeSuffixSum(List<Integer> bounds) {
        List<Integer> suffixSums = new ArrayList<>();
        long totalSum = 0;
        
        // Handle empty list case
        if (bounds == null || bounds.isEmpty()) {
            return new Pair<>(suffixSums, totalSum);
        }

        // Calculate total sum first
        for (int num : bounds) {
            totalSum += num;
        }

        // Calculate suffix sums
        int currentSum = 0;
        for (int i = bounds.size() - 1; i >= 0; i--) {
            currentSum += bounds.get(i);
            suffixSums.add(0, currentSum); // Add at beginning to maintain order
        }

        return new Pair<>(suffixSums, totalSum);
    }
}