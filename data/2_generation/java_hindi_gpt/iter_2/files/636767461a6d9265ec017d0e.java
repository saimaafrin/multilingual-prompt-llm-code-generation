import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class SuffixSumCalculator {

    /** 
     * {@code bounds} का एक सुफिक्स सम की गणना करता है। गणना की गई सुफिक्स सम और {@code bounds list} में सभी तत्वों का योग लौटाता है।
     * @param bounds पूर्णांकों की सूची।
     * @return गणना की गई सुफिक्स सम सूची और सभी तत्वों का योग।
     */
    private Pair<List<Integer>, Long> computeSuffixSum(List<Integer> bounds) {
        List<Integer> suffixSum = new ArrayList<>();
        long totalSum = 0;
        int n = bounds.size();

        // Calculate the suffix sum
        for (int i = n - 1; i >= 0; i--) {
            totalSum += bounds.get(i);
            suffixSum.add(0, totalSum); // Add to the front to maintain order
        }

        // Calculate the total sum of bounds
        long boundsSum = bounds.stream().mapToLong(Integer::longValue).sum();

        return new Pair<>(suffixSum, boundsSum);
    }
}