import java.util.Arrays;

public class ArrayUtils {
    public static String[] addStringToArray(String[] array, String str) {
        if (array == null) {
            return new String[]{str};
        }
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[array.length] = str;
        return newArray;
    }

    public static void main(String[] args) {
        String[] array = {"Hello", "World"};
        String str = "Java";
        String[] result = addStringToArray(array, str);
        System.out.println(Arrays.toString(result)); // Output: [Hello, World, Java]
    }
}