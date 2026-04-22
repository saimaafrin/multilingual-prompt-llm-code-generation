import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CollectionUtils {

    /**
     * Convierte la colección dada en un arreglo de Strings. El arreglo devuelto no contiene entradas <code>null</code>. 
     * Tenga en cuenta que {@link Arrays#sort(Object[])} lanzará una {@link NullPointerException} si un elemento del arreglo es <code>null</code>.
     * @param collection La colección a convertir
     * @return Un nuevo arreglo de Strings.
     */
    static String[] toNoNullStringArray(Collection<?> collection) {
        if (collection == null) {
            return new String[0];
        }

        // Filtrar elementos no nulos y convertirlos a String
        ArrayList<String> nonNullStrings = new ArrayList<>();
        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (element != null) {
                nonNullStrings.add(element.toString());
            }
        }

        // Convertir la lista a un arreglo de Strings
        return nonNullStrings.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Collection<Object> collection = Arrays.asList("Hola", null, 123, null, "Mundo");
        String[] result = toNoNullStringArray(collection);
        System.out.println(Arrays.toString(result)); // Imprime: [Hola, 123, Mundo]
    }
}