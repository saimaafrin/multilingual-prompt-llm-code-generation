import java.util.Collection;

public class CollectionUtils {
    
    public static <E> E findFirstMatch(Collection<E> source, Collection<E> candidates) {
        if (source == null || candidates == null) {
            return null;
        }
        
        for (E candidate : candidates) {
            if (source.contains(candidate)) {
                return candidate;
            }
        }
        
        return null;
    }
}