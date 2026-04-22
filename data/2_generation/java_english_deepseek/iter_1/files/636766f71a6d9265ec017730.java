import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        List<String> nonNullStrings = new ArrayList<>();
        for (Object obj : collection) {
            if (obj != null) {
                nonNullStrings.add(obj.toString());
            }
        }

        return nonNullStrings.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Example usage
        Collection<Object> collection = List.of("Hello", null, 123, "World", null);
        String[] result = toNoNullStringArray(collection);
        for (String str : result) {
            System.out.println(str);
        }
    }
}