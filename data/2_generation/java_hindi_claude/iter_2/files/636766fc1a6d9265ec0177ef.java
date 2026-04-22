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
        
        // Check if array contains any null elements
        boolean hasNull = false;
        for (String element : array) {
            if (element == null) {
                hasNull = true;
                break;
            }
        }
        
        // If no null elements, return original array
        if (!hasNull) {
            return array;
        }
        
        // Create new array without null elements
        return Arrays.stream(array)
                .filter(Objects::nonNull)
                .toArray(String[]::new);
    }
}