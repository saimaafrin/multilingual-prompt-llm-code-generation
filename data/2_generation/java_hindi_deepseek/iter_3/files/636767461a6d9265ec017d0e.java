import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javafx.util.Pair;

public class SuffixSumCalculator {

    /**
     * {@code bounds} का एक सुफिक्स सम की गणना करता है। गणना की गई सुफिक्स सम और {@code bounds list} में सभी तत्वों का योग लौटाता है।
     * @param bounds पूर्णांकों की सूची।
     * @return गणना की गई सुफिक्स सम सूची और सभी तत्वों का योग।
     */
    private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
        if (bounds == null || bounds.isEmpty()) {
            return new Pair<>(Collections.emptyList(), 0L);
        }

        List<Integer> suffixSums = new ArrayList<>();
        long totalSum = 0;
        int currentSum = 0;

        // Calculate suffix sums and total sum
        for (int i = bounds.size() - 1; i >= 0; i--) {
            currentSum += bounds.get(i);
            suffixSums.add(currentSum);
            totalSum += bounds.get(i);
        }

        // Reverse the suffixSums list to get the correct order
        Collections.reverse(suffixSums);

        return new Pair<>(suffixSums, totalSum);
    }
}