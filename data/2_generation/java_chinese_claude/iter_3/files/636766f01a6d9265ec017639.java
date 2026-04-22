import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtils {
    /**
     * 数组转列表。<p> 其工作方式类似于 {@link Arrays#asList(Object)}，但可以处理空数组。
     * @return 一个由数组支持的列表。
     */
    public static <T> List<T> asList(T[] a) {
        if (a == null || a.length == 0) {
            return new ArrayList<T>();
        }
        return Arrays.asList(a);
    }
}