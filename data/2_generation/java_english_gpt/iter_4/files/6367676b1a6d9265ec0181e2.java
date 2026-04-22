import java.util.Collection;

public class MatchFinder {
    /** 
     * Return the first element in '<code>candidates</code>' that is contained in '<code>source</code>'. If no element in '<code>candidates</code>' is present in '<code>source</code>' returns <code>null</code>. Iteration order is {@link Collection} implementation specific.
     * @param source the source Collection
     * @param candidates the candidates to search for
     * @return the first present object, or <code>null</code> if not found
     */
    public static Object findFirstMatch(Collection source, Collection candidates) {
        for (Object candidate : candidates) {
            if (source.contains(candidate)) {
                return candidate;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Example usage
        Collection<String> source = List.of("apple", "banana", "cherry");
        Collection<String> candidates = List.of("grape", "banana", "orange");
        
        Object match = findFirstMatch(source, candidates);
        System.out.println(match); // Output: banana
    }
}