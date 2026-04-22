import java.util.Collection;
import java.util.ArrayList;
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

        ArrayList<String> nonNullList = new ArrayList<>();
        Iterator<?> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (element != null) {
                nonNullList.add(element.toString());
            }
        }

        return nonNullList.toArray(new String[0]);
    }
}