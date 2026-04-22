import java.util.Arrays;

public class StringArrayTrimmer {
    
    /** 
     * Trim the elements of the given String array, calling <code>String.trim()</code> on each of them.
     * @param array the original String array
     * @return the resulting array (of the same size) with trimmed elements
     */
    public static String[] trimArrayElements(String[] array) {
        if (array == null) {
            return null;
        }
        return Arrays.stream(array)
                     .map(String::trim)
                     .toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] input = {"  Hello  ", "  World  ", null, "  Java  "};
        String[] trimmed = trimArrayElements(input);
        System.out.println(Arrays.toString(trimmed));
    }
}