import java.util.ArrayList;
import java.util.List;

public class BPlusTree<K extends Comparable<K>> {

    private List<Integer> computeUpperBounds(List<K> keys) {
        List<Integer> upperBounds = new ArrayList<>();
        
        if (keys == null || keys.isEmpty()) {
            return upperBounds;
        }

        // Initialize first upper bound
        upperBounds.add(0);
        
        // Compare each adjacent pair of keys
        for (int i = 1; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            K previousKey = keys.get(i-1);
            
            // If keys are equal, use same upper bound
            if (currentKey.compareTo(previousKey) == 0) {
                upperBounds.add(upperBounds.get(i-1));
            }
            // If keys are different, increment upper bound
            else {
                upperBounds.add(upperBounds.get(i-1) + 1);
            }
        }
        
        return upperBounds;
    }
}