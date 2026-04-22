import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ArrayUtils {
    /**
     * Array to List. <p> Works like {@link Arrays#asList(Object)}, but handles null arrays.
     * @param a the array to convert to a List
     * @return a list backed by the array
     */
    public static <T> List<T> asList(T[] a) {
        if (a == null) {
            return new ArrayList<T>();
        }
        return Arrays.asList(a);
    }
}