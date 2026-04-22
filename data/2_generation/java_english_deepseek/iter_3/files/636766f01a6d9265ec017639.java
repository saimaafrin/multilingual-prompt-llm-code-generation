import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToList {

    /**
     * Array to List. <p> Works like  {@link Arrays#asList(Object)}, but handles null arrays.
     * @param a the array to be converted to a list
     * @return a list backed by the array.
     */
    public static <T> List<T> asList(T[] a) {
        if (a == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(Arrays.asList(a));
    }
}