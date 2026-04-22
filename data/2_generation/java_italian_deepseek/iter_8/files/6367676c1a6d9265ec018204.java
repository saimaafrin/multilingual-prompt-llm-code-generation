import java.util.ArrayList;
import java.util.List;

public class StringArrayConcatenator {

    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        if (array1 == null && array2 == null) {
            return null;
        }

        List<String> result = new ArrayList<>();

        if (array1 != null) {
            for (String s : array1) {
                result.add(s);
            }
        }

        if (array2 != null) {
            for (String s : array2) {
                result.add(s);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] array1 = {"Hello", "World"};
        String[] array2 = {"Java", "Code"};
        String[] result = concatenateStringArrays(array1, array2);

        for (String s : result) {
            System.out.println(s);
        }
    }
}