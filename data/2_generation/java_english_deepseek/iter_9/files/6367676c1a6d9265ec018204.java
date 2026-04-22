import java.util.ArrayList;
import java.util.List;

public class StringArrayConcatenator {

    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        if (array1 == null && array2 == null) {
            return null;
        }

        List<String> result = new ArrayList<>();

        if (array1 != null) {
            for (String element : array1) {
                result.add(element);
            }
        }

        if (array2 != null) {
            for (String element : array2) {
                result.add(element);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] array1 = {"Hello", "World"};
        String[] array2 = {"World", "Java"};
        String[] result = concatenateStringArrays(array1, array2);

        for (String str : result) {
            System.out.println(str);
        }
    }
}