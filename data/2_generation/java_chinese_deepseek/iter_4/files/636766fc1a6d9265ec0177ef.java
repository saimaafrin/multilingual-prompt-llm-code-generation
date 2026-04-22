import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

    /**
     * 返回一个不包含空元素的新字符串数组。此内部方法用于规范化排除列表（数组和集合）。请注意，如果数组元素为 <code>null</code>，{@link Arrays#sort(Object[])} 将抛出 {@link NullPointerException}。
     * @param array 要检查的数组
     * @return 给定数组或一个不包含空值的新数组。
     */
    public static String[] toNoNullStringArray(Object[] array) {
        if (array == null) {
            return new String[0];
        }

        List<String> nonNullList = new ArrayList<>();
        for (Object element : array) {
            if (element != null) {
                nonNullList.add(element.toString());
            }
        }

        return nonNullList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Object[] testArray = { "Hello", null, "World", null, "Java" };
        String[] result = toNoNullStringArray(testArray);
        for (String str : result) {
            System.out.println(str);
        }
    }
}