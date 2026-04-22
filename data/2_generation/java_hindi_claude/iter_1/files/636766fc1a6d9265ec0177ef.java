import java.util.Arrays;
import java.util.Objects;

public class ArrayUtils {
    /**
     * Returns a new array of Strings without null elements. Internal method used to normalize exclude lists (arrays and collections). Note that  {@link Arrays#sort(Object[])} will throw an {@link NullPointerException}if an array element is <code>null</code>.
     * @param array The array to check
     * @return The given array or a new array without null.
     */
    public static String[] getNonNullArray(String[] array) {
        if (array == null) {
            return new String[0];
        }
        
        // Count non-null elements
        int nonNullCount = 0;
        for (String element : array) {
            if (element != null) {
                nonNullCount++;
            }
        }
        
        // If no null elements, return original array
        if (nonNullCount == array.length) {
            return array;
        }
        
        // Create new array with only non-null elements
        String[] result = new String[nonNullCount];
        int index = 0;
        for (String element : array) {
            if (element != null) {
                result[index++] = element;
            }
        }
        
        return result;
    }
}