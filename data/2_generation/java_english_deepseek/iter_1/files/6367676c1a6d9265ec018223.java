import java.util.Collection;
import java.util.Iterator;

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
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object current = iterator.next();
            if (current == element) {
                return true;
            }
        }
        return false;
    }
}