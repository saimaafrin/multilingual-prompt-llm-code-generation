import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToList {

    /**
     * Array a Lista. <p> Funciona como {@link Arrays#asList(Object)}, pero maneja arreglos nulos.
     * @param a el arreglo de elementos a convertir en lista.
     * @return una lista respaldada por el arreglo.
     */
    public static <T> List<T> asList(T[] a) {
        if (a == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(Arrays.asList(a));
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String[] array = {"a", "b", "c"};
        List<String> list = asList(array);
        System.out.println(list); // [a, b, c]

        String[] nullArray = null;
        List<String> nullList = asList(nullArray);
        System.out.println(nullList); // []
    }
}