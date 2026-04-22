import java.util.HashSet;
import java.util.Set;

public class SetOperations<V> {

    /** 
     * Efficient way to compute the intersection between two sets
     * @param set1 set $1$
     * @param set2 set $2$
     * @return intersection of set $1$ and $2$
     */
    private Set<V> intersection(Set<V> set1, Set<V> set2) {
        Set<V> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }
}