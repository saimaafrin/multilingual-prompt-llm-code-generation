import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToList {

    /**
     * Array a Lista. <p> Funciona como {@link Arrays#asList(Object)}, pero maneja arreglos nulos.
     * @param a el arreglo de elementos
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
        String[] array = {"Hola", "Mundo"};
        List<String> lista = asList(array);
        System.out.println(lista);

        // Ejemplo con arreglo nulo
        String[] arrayNulo = null;
        List<String> listaNula = asList(arrayNulo);
        System.out.println(listaNula);
    }
}