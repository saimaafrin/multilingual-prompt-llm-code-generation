import java.util.Objects;

public class ArrayUtils {

    // 定义一个公共静态的空数组引用
    public static final Double[] EMPTY_DOUBLE_ARRAY = new Double[0];

    /**
     * <p>防御性编程技术，将 <code>null</code> 引用转换为一个空引用。</p> 
     * <p>该方法对于 <code>null</code> 输入数组返回一个空数组。</p> 
     * <p>作为内存优化技术，传入的空数组将被本类中的空 <code>public static</code> 引用覆盖。</p>
     * @param array  要检查是否为 <code>null</code> 或空的数组
     * @return 相同的数组，如果输入为 <code>null</code> 或空，则返回 <code>public static</code> 空数组
     * @since 2.5
     */
    public static Double[] nullToEmpty(final Double[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        return array;
    }

    // 测试代码
    public static void main(String[] args) {
        Double[] array1 = null;
        Double[] array2 = new Double[0];
        Double[] array3 = new Double[]{1.0, 2.0, 3.0};

        System.out.println(Objects.isNull(nullToEmpty(array1))); // false
        System.out.println(nullToEmpty(array1).length); // 0
        System.out.println(nullToEmpty(array2).length); // 0
        System.out.println(nullToEmpty(array3).length); // 3
    }
}