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
        // Create new set to store intersection
        Set<V> intersection = new HashSet<>();
        
        // Iterate through smaller set for efficiency
        if (set1.size() < set2.size()) {
            for (V element : set1) {
                if (set2.contains(element)) {
                    intersection.add(element);
                }
            }
        } else {
            for (V element : set2) {
                if (set1.contains(element)) {
                    intersection.add(element);
                }
            }
        }
        
        return intersection;
    }
}