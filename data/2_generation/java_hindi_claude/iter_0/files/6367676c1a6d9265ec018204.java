import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
    public static String[] concatenateArrays(String[] array1, String[] array2) {
        // Handle null cases
        if (array1 == null && array2 == null) {
            return null;
        }
        if (array1 == null) {
            return array2.clone();
        }
        if (array2 == null) {
            return array1.clone();
        }

        // Use ArrayList to build result
        List<String> result = new ArrayList<>();

        // Add all elements from first array
        for (String s : array1) {
            result.add(s);
        }

        // Add all elements from second array
        for (String s : array2) {
            result.add(s);
        }

        // Convert back to array
        return result.toArray(new String[0]);
    }
}