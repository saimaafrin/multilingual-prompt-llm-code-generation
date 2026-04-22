import java.util.HashSet;
import java.util.Set;

public class IntersectionExample<V> {

    /**
     * Método eficiente para calcular la intersección entre dos conjuntos
     * @param set1 conjunto $1$
     * @param set2 conjunto $2$
     * @return intersección del conjunto $1$ y $2$
     */
    private Set<V> interseccion(Set<V> set1, Set<V> set2) {
        Set<V> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }
}