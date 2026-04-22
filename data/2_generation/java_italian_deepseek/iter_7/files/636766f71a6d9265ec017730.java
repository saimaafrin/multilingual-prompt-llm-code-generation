import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionUtils {

    /**
     * Converte la Collection fornita in un array di Stringhe. L'array restituito non contiene elementi <code>null</code>.
     * Si noti che {@link Arrays#sort(Object[])} genererà un {@link NullPointerException} se un elemento dell'array è <code>null</code>.
     * @param collection La collezione da convertire
     * @return Un nuovo array di Stringhe.
     */
    static String[] toNoNullStringArray(Collection<?> collection) {
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
        Collection<Object> collection = Arrays.asList("Hello", null, "World", 123, null);
        String[] result = toNoNullStringArray(collection);
        System.out.println(Arrays.toString(result)); // Output: [Hello, World, 123]
    }
}