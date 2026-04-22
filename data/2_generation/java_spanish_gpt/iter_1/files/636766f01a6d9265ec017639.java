import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToList {

    /** 
     * Array a Lista. <p> Funciona como {@link Arrays#asList(Object)},pero maneja arreglos nulos.
     * @return una lista respaldada por el arreglo.
     */
    public static <T> List<T> asList(T[] a) {
        if (a == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(a);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String[] array = {"uno", "dos", "tres"};
        List<String> list = asList(array);
        System.out.println(list); // Imprime: [uno, dos, tres]

        String[] nullArray = null;
        List<String> nullList = asList(nullArray);
        System.out.println(nullList); // Imprime: []
    }
}