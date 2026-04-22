import java.util.HashSet;
import java.util.Set;

public class SetIntersection {

    /**
     * Metodo efficiente per calcolare l'intersezione tra due insiemi
     * @param set1 insieme $1$
     * @param set2 insieme $2$
     * @return intersezione dell'insieme $1$ e $2$
     */
    private static <V> Set<V> intersection(Set<V> set1, Set<V> set2) {
        Set<V> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Set<Integer> intersectionResult = intersection(set1, set2);
        System.out.println("Intersection: " + intersectionResult); // Output: Intersection: [2, 3]
    }
}