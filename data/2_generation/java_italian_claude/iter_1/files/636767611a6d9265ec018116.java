import java.util.HashSet;
import java.util.Set;

public class SetOperations<V> {

    /**
     * Metodo efficiente per calcolare l'intersezione tra due insiemi
     * @param set1 insieme $1$
     * @param set2 insieme $2$ 
     * @return intersezione dell'insieme $1$ e $2$
     */
    private Set<V> intersection(Set<V> set1, Set<V> set2) {
        // Create new set for result
        Set<V> result = new HashSet<>();
        
        // Get smaller set to iterate over
        Set<V> smaller = set1.size() < set2.size() ? set1 : set2;
        Set<V> larger = set1.size() < set2.size() ? set2 : set1;

        // Add elements that exist in both sets
        for (V element : smaller) {
            if (larger.contains(element)) {
                result.add(element);
            }
        }
        
        return result;
    }
}