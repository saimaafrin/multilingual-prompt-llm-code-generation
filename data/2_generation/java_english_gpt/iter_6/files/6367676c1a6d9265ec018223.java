import java.util.Collection;

public class CollectionUtils {
    /** 
     * Check whether the given Collection contains the given element instance. <p>Enforces the given instance to be present, rather than returning <code>true</code> for an equal element as well.
     * @param collection the Collection to check
     * @param element the element to look for
     * @return <code>true</code> if found, <code>false</code> else
     */
    public static boolean containsInstance(Collection collection, Object element) {
        if (collection == null || element == null) {
            return false;
        }
        for (Object obj : collection) {
            if (obj == element) {
                return true;
            }
        }
        return false;
    }
}