import java.util.HashSet;
import java.util.Set;

public class SetIntersection {

    /**
     * 高效计算两个集合交集的方法
     * @param set1 集合 $1$
     * @param set2 集合 $2$
     * @return 集合 $1$ 和 $2$ 的交集
     */
    private static <V> Set<V> intersection(Set<V> set1, Set<V> set2) {
        Set<V> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static void main(String[] args) {
        // 示例用法
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Set<Integer> intersectionSet = intersection(set1, set2);
        System.out.println("Intersection: " + intersectionSet); // 输出: Intersection: [2, 3]
    }
}