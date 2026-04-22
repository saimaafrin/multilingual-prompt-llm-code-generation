import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javafx.util.Pair;

private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
    if (bounds == null || bounds.isEmpty()) {
        return new Pair<>(Collections.emptyList(), 0L);
    }

    List<Integer> suffixSums = new ArrayList<>();
    long totalSum = 0;
    int suffixSum = 0;

    // Calcola la somma totale e la somma dei suffissi
    for (int i = bounds.size() - 1; i >= 0; i--) {
        suffixSum += bounds.get(i);
        suffixSums.add(suffixSum);
        totalSum += bounds.get(i);
    }

    // Inverti la lista dei suffissi per avere l'ordine corretto
    Collections.reverse(suffixSums);

    return new Pair<>(suffixSums, totalSum);
}