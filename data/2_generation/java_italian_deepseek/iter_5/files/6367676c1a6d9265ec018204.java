import java.util.ArrayList;
import java.util.List;

public class ArrayConcatenator {

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

        // Handle overlapping elements by adding them twice
        if (array1 != null && array2 != null && array1.length > 0 && array2.length > 0) {
            result.add(array1[array1.length - 1]);
            result.add(array2[0]);
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] array1 = {"A", "B", "C"};
        String[] array2 = {"C", "D", "E"};

        String[] result = concatenateStringArrays(array1, array2);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}