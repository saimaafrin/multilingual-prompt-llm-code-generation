import java.util.HashSet;
import java.util.Set;

public class SetIntersection {

    /**
     * Efficient way to compute the intersection between two sets
     * @param set1 set $1$
     * @param set2 set $2$
     * @return intersection of set $1$ and $2$
     */
    private static <V> Set<V> intersection(Set<V> set1, Set<V> set2) {
        Set<V> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Set<Integer> intersectionSet = intersection(set1, set2);
        System.out.println("Intersection: " + intersectionSet); // Output: [2, 3]
    }
}