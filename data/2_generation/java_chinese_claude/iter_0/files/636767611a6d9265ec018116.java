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
        // Create a new set to store intersection
        Set<V> result = new HashSet<>();
        
        // Choose smaller set to iterate over for better performance
        Set<V> smallerSet = set1.size() < set2.size() ? set1 : set2;
        Set<V> largerSet = set1.size() < set2.size() ? set2 : set1;
        
        // Iterate through smaller set and check if elements exist in larger set
        for (V element : smallerSet) {
            if (largerSet.contains(element)) {
                result.add(element);
            }
        }
        
        return result;
    }
}