import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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

        // Filtra gli elementi non nulli e li converte in Stringhe
        ArrayList<String> filteredList = new ArrayList<>();
        for (Object obj : collection) {
            if (obj != null) {
                filteredList.add(obj.toString());
            }
        }

        // Converti la lista filtrata in un array di Stringhe
        return filteredList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
        Collection<Object> collection = Arrays.asList("Hello", null, 123, null, "World");
        String[] result = toNoNullStringArray(collection);
        System.out.println(Arrays.toString(result)); // Output: [Hello, 123, World]
    }
}