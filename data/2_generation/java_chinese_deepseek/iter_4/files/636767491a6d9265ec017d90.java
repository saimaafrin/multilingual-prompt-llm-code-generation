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
        Objects.requireNonNull(arr, "数组不能为null");
        if (from < 0 || to >= arr.length || from > to) {
            throw new IllegalArgumentException("无效的索引范围");
        }

        while (from < to) {
            V temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            from++;
            to--;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        reverse(arr, 1, 3);
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
        // 输出: 1 4 3 2 5
    }
}