import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.lang3.tuple.Pair;

private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
    if (bounds == null || bounds.isEmpty()) {
        return Pair.of(Collections.emptyList(), 0L);
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

    return Pair.of(suffixSums, totalSum);
}