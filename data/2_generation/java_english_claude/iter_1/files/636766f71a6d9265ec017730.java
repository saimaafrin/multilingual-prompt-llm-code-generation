import java.util.Collection;
import java.util.ArrayList;

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

        ArrayList<String> list = new ArrayList<>();
        
        for (Object obj : collection) {
            if (obj != null) {
                list.add(obj.toString());
            }
        }

        return list.toArray(new String[0]);
    }
}