import java.util.*;

public class BoundCalculator<K extends Comparable<K>> {

    /**
     * 为每个键找到一个最大下界。
     * @param keys 键的列表。
     * @return 计算出的键的下界。
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> bounds = new ArrayList<>(keys.size());
        
        // For each key, find its lower bound
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int lowerBound = 0;
            
            // Compare with all previous keys
            for (int j = 0; j < i; j++) {
                if (keys.get(j).compareTo(currentKey) <= 0) {
                    lowerBound = Math.max(lowerBound, j + 1);
                }
            }
            
            bounds.add(lowerBound);
        }
        
        return bounds;
    }
}