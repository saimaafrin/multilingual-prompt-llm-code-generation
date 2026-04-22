import java.util.Objects;

public class ArrayUtils {

    /**
     * <p>将对象类型的 Integer 数组转换为基本类型。</p> <p>如果输入数组为 <code>null</code>，则此方法返回 <code>null</code>。</p>
     * @param array  一个 <code>Integer</code> 数组，可以为 <code>null</code>
     * @return 一个 <code>int</code> 数组，如果输入数组为空则返回 <code>null</code>
     * @throws NullPointerException 如果数组内容为 <code>null</code>
     */
    public static int[] toPrimitive(final Integer[] array) {
        if (array == null) {
            return null;
        }
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Objects.requireNonNull(array[i], "Array element cannot be null");
        }
        return result;
    }
}