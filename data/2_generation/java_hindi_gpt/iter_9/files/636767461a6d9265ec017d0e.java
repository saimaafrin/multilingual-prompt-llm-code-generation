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

        // Calculate the total sum of bounds
        for (int value : bounds) {
            totalSum += value;
        }

        // Calculate the suffix sums
        int currentSuffixSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            currentSuffixSum += bounds.get(i);
            suffixSum.add(currentSuffixSum);
        }

        // Reverse the suffix sum list to maintain the original order
        List<Integer> reversedSuffixSum = new ArrayList<>();
        for (int i = suffixSum.size() - 1; i >= 0; i--) {
            reversedSuffixSum.add(suffixSum.get(i));
        }

        return new Pair<>(reversedSuffixSum, totalSum);
    }
}