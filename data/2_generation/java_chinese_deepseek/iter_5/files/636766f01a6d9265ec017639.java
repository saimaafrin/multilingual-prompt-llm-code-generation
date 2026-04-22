import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToList {

    /**
     * 数组转列表。<p> 其工作方式类似于 {@link Arrays#asList(Object)}，但可以处理空数组。
     * @param a 要转换的数组
     * @return 一个由数组支持的列表。
     */
    public static <T> List<T> asList(T[] a) {
        if (a == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(Arrays.asList(a));
    }

    public static void main(String[] args) {
        // 示例用法
        String[] array = {"a", "b", "c"};
        List<String> list = asList(array);
        System.out.println(list);  // 输出: [a, b, c]

        String[] emptyArray = {};
        List<String> emptyList = asList(emptyArray);
        System.out.println(emptyList);  // 输出: []

        String[] nullArray = null;
        List<String> nullList = asList(nullArray);
        System.out.println(nullList);  // 输出: []
    }
}