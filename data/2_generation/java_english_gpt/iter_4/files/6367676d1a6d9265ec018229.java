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
        String[] trimmedArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            trimmedArray[i] = array[i] != null ? array[i].trim() : null;
        }
        return trimmedArray;
    }

    public static void main(String[] args) {
        String[] testArray = {"  Hello  ", "  World  ", null, "  Java  "};
        String[] trimmedArray = trimArrayElements(testArray);
        System.out.println(Arrays.toString(trimmedArray));
    }
}