import java.util.Arrays;
import java.util.List;

public class ArrayToListConverter {
    /** 
     * 数组转列表。<p> 其工作方式类似于 {@link Arrays#asList(Object)}，但可以处理空数组。
     * @return 一个由数组支持的列表。
     */
    public static <T> List<T> asList(T[] a) {
        return a == null ? Arrays.asList() : Arrays.asList(a);
    }

    public static void main(String[] args) {
        String[] array = {"Hello", "World"};
        List<String> list = asList(array);
        System.out.println(list); // Output: [Hello, World]

        String[] emptyArray = {};
        List<String> emptyList = asList(emptyArray);
        System.out.println(emptyList); // Output: []
    }
}