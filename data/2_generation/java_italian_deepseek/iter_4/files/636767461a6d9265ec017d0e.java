import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class SuffixSumCalculator {

    /**
     * Calcola la somma dei suffissi di {@code bounds}. Restituisce la somma dei suffissi calcolata e la somma totale di tutti gli elementi nella lista {@code bounds}.
     * @param bounds lista di interi.
     * @return coppia calcolata di lista di somma suffisso e somma di tutti gli elementi.
     */
    private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
        Objects.requireNonNull(bounds, "La lista bounds non può essere null");

        List<Integer> suffixSums = new ArrayList<>();
        long totalSum = 0;
        int currentSuffixSum = 0;

        // Calcola la somma totale e la somma dei suffissi
        for (int i = bounds.size() - 1; i >= 0; i--) {
            currentSuffixSum += bounds.get(i);
            suffixSums.add(0, currentSuffixSum); // Aggiungi all'inizio per mantenere l'ordine corretto
            totalSum += bounds.get(i);
        }

        return new Pair<>(suffixSums, totalSum);
    }

    // Classe Pair per rappresentare la coppia di valori
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

    public static void main(String[] args) {
        SuffixSumCalculator calculator = new SuffixSumCalculator();
        List<Integer> bounds = List.of(1, 2, 3, 4);
        Pair<List<Integer>, Long> result = calculator.computeSuffixSum(bounds);

        System.out.println("Somma dei suffissi: " + result.getFirst());
        System.out.println("Somma totale: " + result.getSecond());
    }
}