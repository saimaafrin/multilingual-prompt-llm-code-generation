import java.util.Objects;

public class ArrayUtils {
    /**
     * Trim the elements of the given String array, calling <code>String.trim()</code> on each of them.
     * @param array the original String array
     * @return the resulting array (of the same size) with trimmed elements
     */
    public static String[] trimArrayElements(String[] array) {
        if (array == null) {
            return null;
        }
        
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            String element = array[i];
            result[i] = element != null ? element.trim() : null;
        }
        return result;
    }
}