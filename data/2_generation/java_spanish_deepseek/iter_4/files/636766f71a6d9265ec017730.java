import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CollectionUtils {

    /**
     * Convierte la colección dada en un arreglo de Strings. El arreglo devuelto no contiene entradas <code>null</code>.
     * Tenga en cuenta que {@link Arrays#sort(Object[])} lanzará una {@link NullPointerException} si un elemento del arreglo es <code>null</code>.
     * @param collection La colección a convertir
     * @return Un nuevo arreglo de Strings.
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
        Collection<Object> collection = Arrays.asList("Hello", null, "World", 123, null);
        String[] result = toNoNullStringArray(collection);
        System.out.println(Arrays.toString(result)); // Output: [Hello, World, 123]
    }
}