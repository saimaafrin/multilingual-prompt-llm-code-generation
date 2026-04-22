import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

    /**
     * Devuelve un nuevo arreglo de Strings sin elementos nulos. Método interno utilizado para normalizar listas de exclusión (arreglo y colecciones). Tenga en cuenta que {@link Arrays#sort(Object[])} lanzará un {@link NullPointerException} si un elemento del arreglo es <code>null</code>.
     * @param array El arreglo a verificar
     * @return El arreglo dado o un nuevo arreglo sin nulos.
     */
    static String[] toNoNullStringArray(Object[] array) {
        if (array == null) {
            return new String[0];
        }

        List<String> nonNullList = new ArrayList<>();
        for (Object element : array) {
            if (element != null) {
                nonNullList.add(element.toString());
            }
        }

        return nonNullList.toArray(new String[0]);
    }
}