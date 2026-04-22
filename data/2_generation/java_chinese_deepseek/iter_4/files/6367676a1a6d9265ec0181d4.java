import java.util.Arrays;

public class ArrayUtils {

    /**
     * 将给定的字符串附加到给定的字符串数组中，返回一个新数组，该数组由输入数组的内容加上给定的字符串组成。
     * @param array 要附加到的数组（可以是 <code>null</code>）
     * @param str 要附加的字符串
     * @return 新数组（绝不会是 <code>null</code>）
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
        System.out.println(Arrays.toString(result)); // 输出: [a, b, c, d]
    }
}