import java.util.Collection;

public class InstanceChecker {
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

    public static void main(String[] args) {
        // Example usage
        Collection<Object> myCollection = new java.util.ArrayList<>();
        Object myElement = new Object();
        myCollection.add(myElement);
        myCollection.add(new Object());

        System.out.println(containsInstance(myCollection, myElement)); // true
        System.out.println(containsInstance(myCollection, new Object())); // false
    }
}