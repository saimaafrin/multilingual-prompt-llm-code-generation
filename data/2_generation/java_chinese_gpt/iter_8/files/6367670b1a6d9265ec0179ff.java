public class ArrayUtil {
    public static final Byte[] EMPTY_ARRAY = new Byte[0];

    /** 
     * <p>防御性编程技术，将 <code>null</code> 引用转换为一个空引用。</p> 
     * <p>对于 <code>null</code> 输入数组，该方法返回一个空数组。</p> 
     * <p>作为一种内存优化技术，传入的空数组将被本类中的空 <code>public static</code> 引用覆盖。</p>
     * @param array  要检查是否为 <code>null</code> 或空的数组
     * @return 相同的数组，如果输入为 <code>null</code> 或空，则返回 <code>public static</code> 空数组
     * @since 2.5
     */
    public static Byte[] nullToEmpty(final Byte[] array) {
        return (array == null || array.length == 0) ? EMPTY_ARRAY : array;
    }

    public static void main(String[] args) {
        Byte[] nullArray = null;
        Byte[] emptyArray = new Byte[0];
        Byte[] nonEmptyArray = {1, 2, 3};

        System.out.println(nullToEmpty(nullArray).length); // Output: 0
        System.out.println(nullToEmpty(emptyArray).length); // Output: 0
        System.out.println(nullToEmpty(nonEmptyArray).length); // Output: 3
    }
}