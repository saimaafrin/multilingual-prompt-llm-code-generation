import java.util.Collection;

public class InstanceChecker {
    /** 
     * Check whether the given Collection contains the given element instance. <p>Enforces the given instance to be present, rather than returning <code>true</code> for an equal element as well.
     * @param collection the Collection to check
     * @param element the element to look for
     * @return <code>true</code> if found, <code>false</code> else
     */
    public static boolean containsInstance(Collection<?> collection, Object element) {
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
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        myCollection.add(str1);

        System.out.println(containsInstance(myCollection, str1)); // true
        System.out.println(containsInstance(myCollection, str2)); // false
    }
}