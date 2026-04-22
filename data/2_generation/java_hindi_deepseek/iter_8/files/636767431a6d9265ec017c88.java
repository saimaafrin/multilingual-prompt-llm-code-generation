import java.util.ArrayList;
import java.util.List;

public class LowerBoundsCalculator<K extends Comparable<K>> {

    /**
     * प्रत्येक कुंजी के लिए अधिकतम निम्न सीमा खोजता है।
     * @param keys कुंजी की सूची।
     * @return गणना की गई कुंजी की निम्न सीमाएँ।
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        List<Integer> lowerBounds = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            int lowerBound = 0;
            for (int j = 0; j < i; j++) {
                if (keys.get(j).compareTo(keys.get(i)) < 0) {
                    lowerBound++;
                }
            }
            lowerBounds.add(lowerBound);
        }
        return lowerBounds;
    }
}