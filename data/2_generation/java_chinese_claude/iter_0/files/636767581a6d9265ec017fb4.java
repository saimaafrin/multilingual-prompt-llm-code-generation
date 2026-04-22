import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class BoundCalculator<K extends Comparable<K>> {

    /**
     * 为每个键找到一个最小上界。
     * @param keys 键的列表。
     * @return 计算得到的键上界。
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> upperBounds = new ArrayList<>(keys.size());
        
        // For each key, find its upper bound
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int upperBound = i;
            
            // Compare with remaining keys to find minimum upper bound
            for (int j = i + 1; j < keys.size(); j++) {
                if (currentKey.compareTo(keys.get(j)) <= 0) {
                    upperBound = j;
                    break;
                }
            }
            
            upperBounds.add(upperBound);
        }

        return upperBounds;
    }
}