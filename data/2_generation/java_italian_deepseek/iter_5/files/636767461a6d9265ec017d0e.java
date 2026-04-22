import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javafx.util.Pair;

public class SuffixSumCalculator {

    /**
     * Calcola la somma dei suffissi di {@code bounds}. Restituisce la somma dei suffissi calcolata e la somma totale di tutti gli elementi nella lista {@code bounds}.
     * @param bounds lista di interi.
     * @return coppia calcolata di lista di somma suffisso e somma di tutti gli elementi.
     */
    private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
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

        // Inverti la lista delle somme dei suffissi per ottenere l'ordine corretto
        Collections.reverse(suffixSums);

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