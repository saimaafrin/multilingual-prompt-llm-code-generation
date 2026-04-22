import java.util.HashSet;
import java.util.Set;

private <V> Set<V> intersection(Set<V> set1, Set<V> set2) {
    Set<V> result = new HashSet<>(set1);
    result.retainAll(set2);
    return result;
}