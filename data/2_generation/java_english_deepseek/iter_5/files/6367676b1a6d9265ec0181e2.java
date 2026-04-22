import java.util.Collection;
import java.util.Iterator;

public class CollectionUtils {
    /**
     * Return the first element in '<code>candidates</code>' that is contained in '<code>source</code>'. If no element in '<code>candidates</code>' is present in '<code>source</code>' returns <code>null</code>. Iteration order is {@link Collection} implementation specific.
     * @param source the source Collection
     * @param candidates the candidates to search for
     * @return the first present object, or <code>null</code> if not found
     */
    public static Object findFirstMatch(Collection source, Collection candidates) {
        if (source == null || candidates == null) {
            return null;
        }

        Iterator<?> iterator = candidates.iterator();
        while (iterator.hasNext()) {
            Object candidate = iterator.next();
            if (source.contains(candidate)) {
                return candidate;
            }
        }

        return null;
    }
}