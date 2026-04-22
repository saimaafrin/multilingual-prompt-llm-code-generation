import java.util.Objects;

public class ArrayUtils {
    /**
     * 反转给定数组中指定范围内元素的顺序。
     * @param <V> 数组中元素的类型
     * @param arr 数组
     * @param from 要反转的范围内第一个元素的索引（包含）
     * @param to 要反转的范围内最后一个元素的索引（包含）
     */
    public static final <V> void reverse(V[] arr, int from, int to) {
        // 参数校验
        Objects.requireNonNull(arr, "Array must not be null");
        if (from < 0 || to >= arr.length || from > to) {
            throw new IllegalArgumentException("Invalid range: from=" + from + ", to=" + to);
        }
        
        // 从两端向中间遍历,交换元素
        while (from < to) {
            V temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            from++;
            to--;
        }
    }
}