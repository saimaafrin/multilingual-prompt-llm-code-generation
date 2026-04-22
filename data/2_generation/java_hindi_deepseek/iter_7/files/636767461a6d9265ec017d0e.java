import java.util.List;
import java.util.ArrayList;
import javafx.util.Pair;

public class SuffixSumCalculator {

    /**
     * {@code bounds} का एक सुफिक्स सम की गणना करता है। गणना की गई सुफिक्स सम और {@code bounds list} में सभी तत्वों का योग लौटाता है।
     * @param bounds पूर्णांकों की सूची।
     * @return गणना की गई सुफिक्स सम सूची और सभी तत्वों का योग।
     */
    private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
        List<Integer> suffixSums = new ArrayList<>();
        long totalSum = 0;
        int currentSum = 0;

        // Calculate suffix sums
        for (int i = bounds.size() - 1; i >= 0; i--) {
            currentSum += bounds.get(i);
            suffixSums.add(0, currentSum); // Add to the beginning to maintain order
            totalSum += bounds.get(i);
        }

        return new Pair<>(suffixSums, totalSum);
    }
}