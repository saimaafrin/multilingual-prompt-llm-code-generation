import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
    /**
     * Concatenate the given String arrays into one, with overlapping array elements included twice.
     * The order of elements in the original arrays is preserved.
     * @param array1 the first array (can be <code>null</code>)
     * @param array2 the second array (can be <code>null</code>) 
     * @return the new array (<code>null</code> if both given arrays were <code>null</code>)
     */
    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        // If both arrays are null, return null
        if (array1 == null && array2 == null) {
            return null;
        }
        
        // If one array is null, return copy of non-null array
        if (array1 == null) {
            return array2.clone();
        }
        if (array2 == null) {
            return array1.clone();
        }

        // Create list to hold concatenated elements
        List<String> result = new ArrayList<>();
        
        // Add all elements from first array
        for (String s : array1) {
            result.add(s);
        }
        
        // Add all elements from second array
        for (String s : array2) {
            result.add(s);
        }

        // Convert list back to array and return
        return result.toArray(new String[0]);
    }
}