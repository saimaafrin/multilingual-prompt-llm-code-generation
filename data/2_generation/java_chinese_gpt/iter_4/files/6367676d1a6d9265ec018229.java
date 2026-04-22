import java.util.Arrays;

public class StringArrayTrimmer {
    /** 
     * 修剪给定字符串数组的元素，对每个元素调用 <code>String.trim()</code> 方法。
     * @param array 原始字符串数组
     * @return 包含修剪后的元素的结果数组（大小相同）
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
        String[] originalArray = {"  Hello  ", "  World  ", "  Java  "};
        String[] trimmedArray = trimArrayElements(originalArray);
        System.out.println(Arrays.toString(trimmedArray));
    }
}