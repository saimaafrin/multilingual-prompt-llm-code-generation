import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayUtils {
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
}