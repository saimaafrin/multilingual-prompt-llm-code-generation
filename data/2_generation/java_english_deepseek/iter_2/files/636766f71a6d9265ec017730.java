import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CollectionUtils {

    /**
     * Converts the given Collection into an array of Strings. The returned array does not contain <code>null</code> entries. Note that  {@link Arrays#sort(Object[])} will throw an {@link NullPointerException} if an array element is <code>null</code>.
     * @param collection The collection to convert
     * @return A new array of Strings.
     */
    public static String[] toNoNullStringArray(Collection<?> collection) {
        if (collection == null) {
            return new String[0];
        }

        // Filter out null values and convert to String
        ArrayList<String> resultList = new ArrayList<>();
        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (element != null) {
                resultList.add(element.toString());
            }
        }

        // Convert the list to an array of Strings
        return resultList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Example usage
        Collection<Object> collection = Arrays.asList("Hello", null, 123, "World", null);
        String[] result = toNoNullStringArray(collection);
        System.out.println(Arrays.toString(result)); // Output: [Hello, 123, World]
    }
}