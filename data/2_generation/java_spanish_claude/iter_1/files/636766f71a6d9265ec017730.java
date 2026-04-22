import java.util.Collection;
import java.util.ArrayList;

public class ArrayConverter {
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

        ArrayList<String> result = new ArrayList<>();
        
        for (Object obj : collection) {
            if (obj != null) {
                result.add(obj.toString());
            }
        }
        
        return result.toArray(new String[0]);
    }
}