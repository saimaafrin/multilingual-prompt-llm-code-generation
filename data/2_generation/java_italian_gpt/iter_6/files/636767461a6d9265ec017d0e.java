import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class SuffixSumCalculator {

    /** 
     * Calcola la somma dei suffissi di {@code bounds}. Restituisce la somma dei suffissi calcolata e la somma totale di tutti gli elementi nella lista {@code bounds}.
     * @param bounds lista di interi.
     * @return coppia calcolata di lista di somma suffisso e somma di tutti gli elementi.
     */
    private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
        List<Integer> suffixSums = new ArrayList<>();
        long totalSum = 0;
        
        // Calcola la somma totale
        for (int num : bounds) {
            totalSum += num;
        }
        
        // Calcola i suffissi
        int suffixSum = 0;
        for (int i = bounds.size() - 1; i >= 0; i--) {
            suffixSum += bounds.get(i);
            suffixSums.add(suffixSum);
        }
        
        // Inverti la lista dei suffissi per avere l'ordine corretto
        List<Integer> reversedSuffixSums = new ArrayList<>();
        for (int i = suffixSums.size() - 1; i >= 0; i--) {
            reversedSuffixSums.add(suffixSums.get(i));
        }
        
        return new Pair<>(reversedSuffixSums, totalSum);
    }
}