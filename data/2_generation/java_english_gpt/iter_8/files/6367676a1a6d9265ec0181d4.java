import java.util.Arrays;

public class StringArrayAppender {
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
        String[] originalArray = {"apple", "banana"};
        String newString = "cherry";
        String[] updatedArray = addStringToArray(originalArray, newString);
        System.out.println(Arrays.toString(updatedArray)); // Output: [apple, banana, cherry]
    }
}