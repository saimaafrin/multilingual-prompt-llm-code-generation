import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToListConverter {

    /**
     * एरे को लिस्ट में बदलें। <p> {@link Arrays#asList(Object)} की तरह काम करता है, लेकिन नल एरे को संभालता है।
     * @param a एरे जिसे लिस्ट में बदलना है।
     * @return एक लिस्ट जो एरे द्वारा समर्थित है।
     */
    public static <T> List<T> asList(T[] a) {
        if (a == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(Arrays.asList(a));
    }

    public static void main(String[] args) {
        // Test case
        String[] array = {"Hello", "World"};
        List<String> list = asList(array);
        System.out.println(list);  // Output: [Hello, World]

        // Test case with null array
        String[] nullArray = null;
        List<String> nullList = asList(nullArray);
        System.out.println(nullList);  // Output: []
    }
}