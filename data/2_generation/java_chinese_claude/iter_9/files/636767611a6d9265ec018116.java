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
        // 创建结果集
        Set<V> result = new HashSet<>();
        
        // 选择较小的集合进行遍历以提高效率
        if (set1.size() > set2.size()) {
            Set<V> temp = set1;
            set1 = set2;
            set2 = temp;
        }
        
        // 遍历较小的集合,检查元素是否在另一个集合中存在
        for (V element : set1) {
            if (set2.contains(element)) {
                result.add(element);
            }
        }
        
        return result;
    }
}