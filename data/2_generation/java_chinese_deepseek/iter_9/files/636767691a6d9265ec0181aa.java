import java.util.Arrays;

public class HashCodeUtil {

    /**
     * 根据指定数组的内容返回一个哈希码。如果 <code>array</code> 为 <code>null</code>，则此方法返回 0。
     * @param array 要获取哈希码的长整型数组
     * @return 长整型数组的哈希码，如果数组为 null，则为 0。
     */
    public static int nullSafeHashCode(long[] array) {
        if (array == null) {
            return 0;
        }
        return Arrays.hashCode(array);
    }

    public static void main(String[] args) {
        long[] array = {1L, 2L, 3L};
        System.out.println(nullSafeHashCode(array)); // 输出数组的哈希码
        System.out.println(nullSafeHashCode(null));  // 输出 0
    }
}