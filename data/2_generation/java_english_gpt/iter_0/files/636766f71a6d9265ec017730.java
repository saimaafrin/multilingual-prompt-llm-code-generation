import java.util.ArrayList;
import java.util.Collection;

public class CollectionUtils {
    
    /** 
     * Converts the given Collection into an array of Strings. The returned array does not contain <code>null</code> entries. Note that  {@link Arrays#sort(Object[])} will throw an {@link NullPointerException} if an array element is <code>null</code>.
     * @param collection The collection to convert
     * @return A new array of Strings.
     */
    static String[] toNoNullStringArray(Collection<?> collection) {
        if (collection == null) {
            return new String[0];
        }
        
        ArrayList<String> stringList = new ArrayList<>();
        for (Object obj : collection) {
            if (obj != null) {
                stringList.add(obj.toString());
            }
        }
        
        return stringList.toArray(new String[0]);
    }
    
    public static void main(String[] args) {
        // Example usage
        Collection<Object> collection = new ArrayList<>();
        collection.add("Hello");
        collection.add(null);
        collection.add("World");
        
        String[] result = toNoNullStringArray(collection);
        for (String str : result) {
            System.out.println(str);
        }
    }
}