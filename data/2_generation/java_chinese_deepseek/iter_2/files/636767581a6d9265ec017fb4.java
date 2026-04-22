import java.util.ArrayList;
import java.util.List;

public class UpperBoundCalculator<K extends Comparable<K>> {

    /**
     * 为每个键找到一个最小上界。
     * @param keys 键的列表。
     * @return 计算得到的键上界。
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        List<Integer> upperBounds = new ArrayList<>();
        if (keys == null || keys.isEmpty()) {
            return upperBounds;
        }

        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int upperBound = Integer.MAX_VALUE;

            for (int j = i + 1; j < keys.size(); j++) {
                K nextKey = keys.get(j);
                if (currentKey.compareTo(nextKey) < 0) {
                    upperBound = Math.min(upperBound, (Integer) nextKey);
                }
            }

            if (upperBound == Integer.MAX_VALUE) {
                upperBound = (Integer) currentKey; // 如果没有找到上界，则上界为自身
            }

            upperBounds.add(upperBound);
        }

        return upperBounds;
    }
}