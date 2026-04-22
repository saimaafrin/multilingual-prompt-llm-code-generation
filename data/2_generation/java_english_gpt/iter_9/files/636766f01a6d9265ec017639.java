import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToList {

    /** 
     * Array to List. <p> Works like  {@link Arrays#asList(Object)}, but handles null arrays.
     * @return a list backed by the array.
     */
    public static <T> List<T> asList(T[] a) {
        if (a == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(a);
    }

    public static void main(String[] args) {
        // Example usage
        String[] array = {"Hello", "World"};
        List<String> list = asList(array);
        System.out.println(list); // Output: [Hello, World]

        String[] nullArray = null;
        List<String> nullList = asList(nullArray);
        System.out.println(nullList); // Output: []
    }
}