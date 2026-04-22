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
        // Create new set to store intersection
        Set<V> intersection = new HashSet<>();
        
        // Iterate over smaller set for efficiency
        if (set1.size() > set2.size()) {
            Set<V> temp = set1;
            set1 = set2;
            set2 = temp;
        }
        
        // Add elements that exist in both sets
        for (V element : set1) {
            if (set2.contains(element)) {
                intersection.add(element);
            }
        }
        
        return intersection;
    }
}