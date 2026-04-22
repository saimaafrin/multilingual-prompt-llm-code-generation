import java.util.HashSet;
import java.util.Set;

public class SetIntersection {

    /**
     * Método eficiente para calcular la intersección entre dos conjuntos
     * @param set1 conjunto $1$
     * @param set2 conjunto $2$
     * @return intersección del conjunto $1$ y $2$
     */
    private static <V> Set<V> interseccion(Set<V> set1, Set<V> set2) {
        Set<V> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Set<Integer> result = interseccion(set1, set2);
        System.out.println("Intersección: " + result); // Output: Intersección: [2, 3]
    }
}