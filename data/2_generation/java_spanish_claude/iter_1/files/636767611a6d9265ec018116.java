import java.util.HashSet;
import java.util.Set;

public class SetOperations<V> {

    /**
     * Método eficiente para calcular la intersección entre dos conjuntos
     * @param set1 conjunto $1$
     * @param set2 conjunto $2$ 
     * @return intersección del conjunto $1$ y $2$
     */
    private Set<V> interseccion(Set<V> set1, Set<V> set2) {
        Set<V> intersection = new HashSet<>();
        
        // Iterate over the smaller set for efficiency
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