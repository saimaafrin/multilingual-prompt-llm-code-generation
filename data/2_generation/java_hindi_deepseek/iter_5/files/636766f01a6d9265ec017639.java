import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToListConverter {

    /**
     * एरे को लिस्ट में बदलें। <p> {@link Arrays#asList(Object)} की तरह काम करता है, लेकिन नल एरे को संभालता है।
     * @param a इनपुट एरे
     * @return एक लिस्ट जो एरे द्वारा समर्थित है।
     */
    public static <T> List<T> asList(T[] a) {
        if (a == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(Arrays.asList(a));
    }

    public static void main(String[] args) {
        // टेस्ट केस
        String[] array = {"Hello", "World"};
        List<String> list = asList(array);
        System.out.println(list);  // [Hello, World]

        List<String> nullList = asList(null);
        System.out.println(nullList);  // []
    }
}