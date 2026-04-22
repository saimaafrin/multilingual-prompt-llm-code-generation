import java.util.HashSet;
import java.util.Set;

public class SetIntersection {

    /**
     * दो सेटों के बीच इंटरसेक्शन की गणना करने का कुशल तरीका
     * @param set1 सेट $1$
     * @param set2 सेट $2$
     * @return सेट $1$ और $2$ का इंटरसेक्शन
     */
    private <V> Set<V> intersection(Set<V> set1, Set<V> set2) {
        Set<V> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static void main(String[] args) {
        SetIntersection example = new SetIntersection();
        
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Set<Integer> intersectionSet = example.intersection(set1, set2);
        System.out.println("Intersection: " + intersectionSet); // Output: Intersection: [2, 3]
    }
}