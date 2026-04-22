import java.util.Arrays;

public class ArrayUtils {

    public static String[] addStringToArray(String[] array, String str) {
        // Handle null array case
        if (array == null) {
            return new String[]{str};
        }

        // Create a new array with one extra slot for the new string
        String[] newArray = Arrays.copyOf(array, array.length + 1);

        // Add the new string to the end of the new array
        newArray[array.length] = str;

        return newArray;
    }

    public static void main(String[] args) {
        // Example usage
        String[] array = {"Hello", "World"};
        String str = "Java";
        String[] result = addStringToArray(array, str);
        System.out.println(Arrays.toString(result)); // Output: [Hello, World, Java]
    }
}