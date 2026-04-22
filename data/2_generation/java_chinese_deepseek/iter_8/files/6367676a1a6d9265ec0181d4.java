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
        String[] array = {"a", "b", "c"};
        String str = "d";
        String[] result = addStringToArray(array, str);
        System.out.println(Arrays.toString(result)); // 输出: [a, b, c, d]

        String[] nullArray = null;
        String[] result2 = addStringToArray(nullArray, "e");
        System.out.println(Arrays.toString(result2)); // 输出: [e]
    }
}