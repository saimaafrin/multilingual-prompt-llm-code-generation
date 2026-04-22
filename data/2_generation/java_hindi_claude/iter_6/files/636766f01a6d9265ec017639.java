import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayUtils {
    /**
     * Array to List. <p> Works like {@link Arrays#asList(Object)}, but handles null arrays.
     * @param <T> the array element type
     * @param array the array to convert to a List
     * @return a list backed by the array
     */
    public static <T> List<T> arrayToList(final T[] array) {
        if (array == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(array);
    }
}