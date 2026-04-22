import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LowerBoundsCalculator<K extends Comparable<K>> {

    /**
     * 为每个键找到一个最大下界。
     * @param keys 键的列表。
     * @return 计算出的键的下界。
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> lowerBounds = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            K currentKey = keys.get(i);
            int lowerBound = -1; // 初始化为-1，表示没有找到下界

            for (int j = 0; j < i; j++) {
                if (keys.get(j).compareTo(currentKey) <= 0) {
                    lowerBound = j;
                }
            }

            lowerBounds.add(lowerBound);
        }

        return lowerBounds;
    }
}