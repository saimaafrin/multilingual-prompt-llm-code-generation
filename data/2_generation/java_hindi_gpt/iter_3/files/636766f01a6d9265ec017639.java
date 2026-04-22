import java.util.Arrays;
import java.util.List;

public class ArrayToListConverter {
    /** 
     * एरे को लिस्ट में बदलें। <p> {@link Arrays#asList(Object)} की तरह काम करता है, लेकिन नल एरे को संभालता है।
     * @return एक लिस्ट जो एरे द्वारा समर्थित है।
     */
    public static <T> List<T> asList(T[] a) {
        if (a == null) {
            return Arrays.asList(); // Return an empty list for null array
        }
        return Arrays.asList(a);
    }

    public static void main(String[] args) {
        String[] array = {"Hello", "World"};
        List<String> list = asList(array);
        System.out.println(list); // Output: [Hello, World]

        String[] nullArray = null;
        List<String> emptyList = asList(nullArray);
        System.out.println(emptyList); // Output: []
    }
}