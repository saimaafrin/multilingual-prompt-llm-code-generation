import java.util.Arrays;

public class ArrayUtils {

    public static String[] addStringToArray(String[] array, String str) {
        // Handle null array case
        if (array == null) {
            return new String[]{str};
        }

        // Create a new array with one extra slot for the new string
        String[] newArray = Arrays.copyOf(array, array.length + 1);

        // Add the new string to the end of the array
        newArray[array.length] = str;

        return newArray;
    }

    public static void main(String[] args) {
        // Example usage
        String[] originalArray = {"Hello", "World"};
        String newString = "!";
        String[] newArray = addStringToArray(originalArray, newString);

        System.out.println(Arrays.toString(newArray)); // Output: [Hello, World, !]
    }
}