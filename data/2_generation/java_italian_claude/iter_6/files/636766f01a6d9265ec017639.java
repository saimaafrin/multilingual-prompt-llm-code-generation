import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayUtils {
    /**
     * Array in Lista. <p> Funziona come {@link Arrays#asList(Object)}, ma gestisce gli array nulli.
     * @param a array da convertire in lista
     * @return una lista supportata dall'array.
     */
    public static <T> List<T> asList(T[] a) {
        if (a == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(a);
    }
}