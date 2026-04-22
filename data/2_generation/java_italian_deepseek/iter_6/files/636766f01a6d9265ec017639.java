import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToList {

    /**
     * Array in Lista. <p> Funziona come {@link Arrays#asList(Object)}, ma gestisce gli array nulli.
     * @param a l'array da convertire in lista
     * @return una lista supportata dall'array.
     */
    public static <T> List<T> asList(T[] a) {
        if (a == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(Arrays.asList(a));
    }

    public static void main(String[] args) {
        // Test case
        String[] array = {"a", "b", "c"};
        List<String> list = asList(array);
        System.out.println(list); // Output: [a, b, c]

        // Test case with null array
        String[] nullArray = null;
        List<String> nullList = asList(nullArray);
        System.out.println(nullList); // Output: []
    }
}