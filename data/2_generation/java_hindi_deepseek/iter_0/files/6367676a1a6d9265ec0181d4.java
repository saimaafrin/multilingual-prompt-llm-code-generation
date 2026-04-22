import java.util.Arrays;

public class ArrayUtils {
    public static String[] addStringToArray(String[] array, String str) {
        // Handle null array case
        if (array == null) {
            return new String[]{str};
        }
        
        // Create a new array with one extra slot
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        
        // Add the new string to the end of the array
        newArray[array.length] = str;
        
        return newArray;
    }
}