import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class UpperBoundCalculator<K extends Comparable<K>> {

    /**
     * 为每个键找到一个最小上界。
     * @param keys 键的列表。
     * @return 计算得到的键上界。
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> upperBounds = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int upperBound = Integer.MAX_VALUE;

            for (int j = 0; j < keys.size(); j++) {
                if (i == j) continue;
                K otherKey = keys.get(j);
                if (currentKey.compareTo(otherKey) < 0 && otherKey.compareTo((K) Integer.valueOf(upperBound)) < 0) {
                    upperBound = (Integer) otherKey;
                }
            }

            upperBounds.add(upperBound);
        }

        return upperBounds;
    }
}