import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LowerBoundCalculator<K extends Comparable<K>> {

    /**
     * 为每个键找到一个最大下界。
     * @param keys 键的列表。
     * @return 计算出的键的下界。
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        List<Integer> lowerBounds = new ArrayList<>();
        if (keys == null || keys.isEmpty()) {
            return lowerBounds;
        }

        // 对键进行排序
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        // 计算每个键的下界
        for (K key : keys) {
            int index = Collections.binarySearch(sortedKeys, key);
            if (index < 0) {
                // 如果键不在列表中，返回插入点的负值减一
                index = -index - 1;
            }
            lowerBounds.add(index);
        }

        return lowerBounds;
    }
}