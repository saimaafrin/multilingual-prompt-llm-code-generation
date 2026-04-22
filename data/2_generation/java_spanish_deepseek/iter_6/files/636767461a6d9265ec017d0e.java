import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SuffixSumCalculator {

    /**
     * Calcula una suma de sufijos de los {@code bounds}. Devuelve la suma de sufijos calculada y la suma de todos los elementos en la {@code lista de bounds}.
     * @param bounds lista de enteros.
     * @return par calculado de la lista de suma de sufijos y la suma de todos los elementos.
     */
    private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
        if (bounds == null || bounds.isEmpty()) {
            return new Pair<>(Collections.emptyList(), 0L);
        }

        List<Integer> suffixSums = new ArrayList<>();
        long totalSum = 0;
        int currentSuffixSum = 0;

        // Calcular la suma total y la suma de sufijos
        for (int i = bounds.size() - 1; i >= 0; i--) {
            currentSuffixSum += bounds.get(i);
            suffixSums.add(currentSuffixSum);
            totalSum += bounds.get(i);
        }

        // Invertir la lista de sufijos para que coincida con el orden original
        Collections.reverse(suffixSums);

        return new Pair<>(suffixSums, totalSum);
    }

    // Clase Pair para devolver dos valores
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

        System.out.println("Suffix Sums: " + result.getFirst());
        System.out.println("Total Sum: " + result.getSecond());
    }
}