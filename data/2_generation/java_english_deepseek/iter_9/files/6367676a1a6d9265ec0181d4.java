import java.util.Arrays;

public class ArrayUtils {

    /**
     * Append the given String to the given String array, returning a new array consisting of the input array contents plus the given String.
     * @param array the array to append to (can be <code>null</code>)
     * @param str the String to append
     * @return the new array (never <code>null</code>)
     */
    public static String[] addStringToArray(String[] array, String str) {
        if (array == null) {
            return new String[]{str};
        }
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[array.length] = str;
        return newArray;
    }

    public static void main(String[] args) {
        String[] array = {"a", "b", "c"};
        String str = "d";
        String[] result = addStringToArray(array, str);
        System.out.println(Arrays.toString(result)); // Output: [a, b, c, d]
    }
}