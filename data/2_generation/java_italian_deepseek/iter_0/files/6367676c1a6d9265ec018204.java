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

        // Handle overlapping elements by adding them twice
        if (array1 != null && array2 != null && array1.length > 0 && array2.length > 0) {
            String lastElementOfArray1 = array1[array1.length - 1];
            String firstElementOfArray2 = array2[0];
            if (lastElementOfArray1.equals(firstElementOfArray2)) {
                result.add(lastElementOfArray1);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] array1 = {"a", "b", "c"};
        String[] array2 = {"c", "d", "e"};
        String[] result = concatenateStringArrays(array1, array2);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}