import java.util.HashSet;
import java.util.Set;

public class SetOperations<V> {
    
    /** 
     * 高效计算两个集合交集的方法
     * @param set1 集合 $1$
     * @param set2 集合 $2$
     * @return 集合 $1$ 和 $2$ 的交集
     */
    private Set<V> intersection(Set<V> set1, Set<V> set2) {
        Set<V> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }
}